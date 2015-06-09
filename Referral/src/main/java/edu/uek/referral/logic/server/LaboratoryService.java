package edu.uek.referral.logic.server;

import edu.uek.referral.api.ReferralStatus;
import edu.uek.referral.api.ResponseStatus;
import edu.uek.referral.api.request.*;
import edu.uek.referral.api.response.*;
import edu.uek.referral.model.entity.ExaminationResult;
import edu.uek.referral.model.entity.Referral;
import edu.uek.referral.model.repository.ExaminationRepository;
import edu.uek.referral.model.repository.ExaminationResultRepository;
import edu.uek.referral.model.repository.ReferralRepository;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ahmed on 09.06.15.
 */
public class LaboratoryService {

    public GetExaminationListResponse getExaminationList(GetExaminationListRequest request) {
        ExaminationRepository examinationRepository = new ExaminationRepository();
        GetExaminationListResponse response = new GetExaminationListResponse();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setExaminationList(examinationRepository.getExaminationList());

        return response;
    }

    public AddNewReferralResponse addNewReferral(AddNewReferralRequest request) {
        ReferralRepository referralRepository = new ReferralRepository();

        Referral ref = new Referral();

        ref.setClientId(request.getClientId());
        ref.setReferralCode(request.getReferral().getReferralCode());
        ref.setCreateDate(new Date());
        ref.setExamination(request.getReferral().getExamination());
        ref.setStatus(ReferralStatus.NEW);

        referralRepository.addReferral(ref);

        AddNewReferralResponse response = new AddNewReferralResponse();

        response.setStatus(ResponseStatus.SUCCESS);

        return response;
    }

    public GetReferralByCodeResponse getReferralById(GetReferralCodeIdRequest request) {
        GetReferralByCodeResponse response = new GetReferralByCodeResponse();

        ReferralRepository referralRepository = new ReferralRepository();
        Referral referral = referralRepository.getReferralByCode(request.getReferralCode());

        ExaminationResultRepository examinationResultRepository = new ExaminationResultRepository();
        ExaminationResult examinationResult = examinationResultRepository.getExaminationResultByReferralId(referral.getId());
        if (examinationResult != null) {
            referral.setExaminationResult(examinationResult);
        }

        response.setReferral(referral);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

    public GetAllReadyReferralsResponse getAllReadyRefferals(GetAllReadyReferralsRequest request) {
        GetAllReadyReferralsResponse response = new GetAllReadyReferralsResponse();

        ReferralRepository referralRepository = new ReferralRepository();
        List<Referral> referralList = referralRepository.getAllReadyReferralForClientList(request.getClientId());

        ExaminationResultRepository examinationResultRepository = new ExaminationResultRepository();
        for (Referral r : referralList) {
            ExaminationResult result = examinationResultRepository.getExaminationResultByReferralId(r.getId());
            r.setExaminationResult(result);
        }

        response.setReferralList(referralList);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

    public GetAllNewReferralsResponse getAllNewReferrals(GetAllNewReferralsRequest request) {
        GetAllNewReferralsResponse response = new GetAllNewReferralsResponse();

        ReferralRepository referralRepository = new ReferralRepository();
        List<Referral> referralList = referralRepository.getAllNewReferralList();

        for (Referral r : referralList) {
            referralRepository.updateReferral(r.getId(), null, ReferralStatus.WAITING);
        }

        response.setReferralList(referralList);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

    public SetExaminationResultsResponse setExaminationResults (SetExaminationResultsRequest request) {
        SetExaminationResultsResponse response = new SetExaminationResultsResponse();

        ReferralRepository referralRepository = new ReferralRepository();
        ExaminationResultRepository examinationResultRepository = new ExaminationResultRepository();

        List<Long> successReferrals = new ArrayList<Long>();

        for (ExaminationResult er : request.getExaminationResultList()) {
            Referral ref = referralRepository.getReferralById(er.getReferralId());
            if (ref == null) {
                response.setStatus(ResponseStatus.INVALID);
                response.setCause("No referral with given code: " + er.getReferralId());
            }

            if (ReferralStatus.WAITING.equals(ref.getStatus()) == false) {
                response.setStatus(ResponseStatus.INVALID);
                response.setCause(String.format("Unable to add examination results for referral with code %s. Wrong status: %s",
                        ref.getReferralCode(), ref.getStatus().toString()));
            }

            examinationResultRepository.addExaminationResult(
                    er.getReferralId(),
                    er.getParameterName(),
                    er.getParameterValue(),
                    er.getParameterUnit(),
                    er.getComment());

            successReferrals.add(er.getReferralId());
        }

        for (Long id : successReferrals) {
            referralRepository.updateReferral(id, new Date(), ReferralStatus.READY);
        }

        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

}
