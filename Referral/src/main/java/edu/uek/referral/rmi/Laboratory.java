package edu.uek.referral.rmi;

import edu.uek.referral.api.request.AddNewReferralRequest;
import edu.uek.referral.api.request.GetAllReadyReferralsRequest;
import edu.uek.referral.api.request.GetExaminationListRequest;
import edu.uek.referral.api.request.GetReferralCodeIdRequest;
import edu.uek.referral.api.response.AddNewReferralResponse;
import edu.uek.referral.api.response.GetAllReadyReferralsResponse;
import edu.uek.referral.api.response.GetExaminationListResponse;
import edu.uek.referral.api.response.GetReferralByCodeResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by bmik on 2015-06-06.
 */
public interface Laboratory extends Remote {

    public GetExaminationListResponse getExaminationList(GetExaminationListRequest request) throws RemoteException;
    public AddNewReferralResponse addNewReferral(AddNewReferralRequest request)  throws RemoteException;
    public GetReferralByCodeResponse getReferralById(GetReferralCodeIdRequest request) throws RemoteException;
    public GetAllReadyReferralsResponse getAllReadyRefferals(GetAllReadyReferralsRequest request) throws RemoteException;

}
