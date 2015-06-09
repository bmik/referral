package edu.uek.referral.logic.server;

import edu.uek.referral.api.request.AddNewReferralRequest;
import edu.uek.referral.api.request.GetExaminationListRequest;
import edu.uek.referral.api.response.GetExaminationListResponse;
import edu.uek.referral.logic.server.impl.LaboratoryImpl;
import edu.uek.referral.model.entity.Examination;
import edu.uek.referral.model.entity.Referral;

import java.rmi.RemoteException;

/**
 * Created by bmik on 2015-06-06.
 */
public class LaboratoryServer {

    public static void main(String[] args) {
        LaboratoryImpl lab = new LaboratoryImpl();

        GetExaminationListRequest request = new GetExaminationListRequest();
        request.setClientId(1234);

        Examination exam = null;

        try {
            GetExaminationListResponse response = lab.getExaminationList(request);
            exam = response.getExaminationList().get(4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        AddNewReferralRequest addNewReferralRequest = new AddNewReferralRequest();

        Referral referral = new Referral();

        referral.setExamintation(exam);
        referral.setReferralCode("123-123");

        addNewReferralRequest.setClientID(000022);
        addNewReferralRequest.setReferral(referral);

        try {
            lab.addNewReferral(addNewReferralRequest);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }

    }

}
