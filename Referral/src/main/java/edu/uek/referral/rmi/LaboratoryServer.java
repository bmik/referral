package edu.uek.referral.rmi;

import edu.uek.referral.logic.util.PropertyHandler;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by bmik on 2015-06-06.
 */
public class LaboratoryServer {

    public static void main(String[] args) {
        /*LaboratoryService service = new LaboratoryService();

        GetExaminationListRequest request = new GetExaminationListRequest();
        request.setClientId(1234);

        Examination exam = null;
        GetExaminationListResponse response = service.getExaminationList(request);
        exam = response.getExaminationList().get(4);

        AddNewReferralRequest addNewReferralRequest = new AddNewReferralRequest();

        Referral referral = new Referral();

        referral.setExamination(exam);
        referral.setReferralCode("123-123");
        referral.setStatus(ReferralStatus.NEW);

        addNewReferralRequest.setClientId(123);
        addNewReferralRequest.setReferral(referral);

        service.addNewReferral(addNewReferralRequest);*/

        registerRmiService();

    }

    private static void registerRmiService() {
        try {
            LaboratoryImpl laboratory = new LaboratoryImpl();
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(PropertyHandler.getProperty("rmi.name"), laboratory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
