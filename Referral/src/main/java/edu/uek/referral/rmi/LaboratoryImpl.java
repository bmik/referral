package edu.uek.referral.rmi;

import edu.uek.referral.api.request.AddNewReferralRequest;
import edu.uek.referral.api.request.GetAllReadyReferralsRequest;
import edu.uek.referral.api.request.GetExaminationListRequest;
import edu.uek.referral.api.request.GetReferralCodeIdRequest;
import edu.uek.referral.api.response.AddNewReferralResponse;
import edu.uek.referral.api.response.GetAllReadyReferralsResponse;
import edu.uek.referral.api.response.GetExaminationListResponse;
import edu.uek.referral.api.response.GetReferralByCodeResponse;
import edu.uek.referral.logic.server.LaboratoryService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by bmik on 2015-06-06.
 */
public class LaboratoryImpl extends UnicastRemoteObject implements Laboratory {

    private final LaboratoryService service = new LaboratoryService();

    public LaboratoryImpl() throws RemoteException {
        super();
    }

    @Override
    public GetExaminationListResponse getExaminationList(GetExaminationListRequest request) throws RemoteException {
        return service.getExaminationList(request);
    }

    @Override
    public AddNewReferralResponse addNewReferral(AddNewReferralRequest request) throws RemoteException {
        return service.addNewReferral(request);
    }

    @Override
    public GetReferralByCodeResponse getReferralById(GetReferralCodeIdRequest request) throws RemoteException {
        return service.getReferralById(request);
    }

    @Override
    public GetAllReadyReferralsResponse getAllReadyRefferals(GetAllReadyReferralsRequest request) throws RemoteException {
        return service.getAllReadyRefferals(request);
    }

}
