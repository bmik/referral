package edu.uek.referral.api;

import edu.uek.referral.api.request.AddNewReferralRequest;
import edu.uek.referral.api.request.GetAllReadyRefferalsRequest;
import edu.uek.referral.api.request.GetExaminationListRequest;
import edu.uek.referral.api.response.AddNewReferralResponse;
import edu.uek.referral.api.response.GetAllReadyRefferalsResponse;
import edu.uek.referral.api.response.GetExaminationListResponse;
import edu.uek.referral.model.entity.Referral;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by bmik on 2015-06-06.
 */
public interface Laboratory extends Remote {

    public GetExaminationListResponse getExaminationList(GetExaminationListRequest request) throws RemoteException;
    public AddNewReferralResponse addNewReferral(AddNewReferralRequest request)  throws RemoteException;
    public GetAllReadyRefferalsResponse getAllReadyRefferals(GetAllReadyRefferalsRequest request) throws RemoteException;

}
