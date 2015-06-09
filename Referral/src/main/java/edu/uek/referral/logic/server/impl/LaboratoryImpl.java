package edu.uek.referral.logic.server.impl;

import edu.uek.referral.api.Laboratory;
import edu.uek.referral.api.ReferralStatus;
import edu.uek.referral.api.ResponseStatus;
import edu.uek.referral.api.request.AddNewReferralRequest;
import edu.uek.referral.api.request.GetAllReadyRefferalsRequest;
import edu.uek.referral.api.request.GetExaminationListRequest;
import edu.uek.referral.api.response.AddNewReferralResponse;
import edu.uek.referral.api.response.GetAllReadyRefferalsResponse;
import edu.uek.referral.api.response.GetExaminationListResponse;
import edu.uek.referral.model.entity.Referral;
import edu.uek.referral.model.repository.ExaminationRepository;
import edu.uek.referral.model.repository.ReferralRepository;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by bmik on 2015-06-06.
 */
public class LaboratoryImpl implements Laboratory {

    public GetExaminationListResponse getExaminationList(GetExaminationListRequest request) throws RemoteException {
        ExaminationRepository examinationRepository = new ExaminationRepository();
        GetExaminationListResponse response = new GetExaminationListResponse();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setExaminationList(examinationRepository.getExaminationList());

        return response;
    }

    public AddNewReferralResponse addNewReferral(AddNewReferralRequest request) throws RemoteException {
        ReferralRepository referralRepository = new ReferralRepository();

        Referral ref = new Referral();

        ref.setClientId(request.getClientID());
        ref.setReferralCode(request.getReferral().getReferralCode());
        ref.setCreateDate(new Date());
        ref.setExamintation(request.getReferral().getExamintation());
        ref.setStatus(ReferralStatus.NEW);

        referralRepository.addReferral(ref);

        AddNewReferralResponse response = new AddNewReferralResponse();

        response.setStatus(ResponseStatus.SUCCESS);

        return response;
    }

    public GetAllReadyRefferalsResponse getAllReadyRefferals(GetAllReadyRefferalsRequest request) throws RemoteException {
        return null;
    }

}
