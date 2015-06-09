package edu.uek.referral.rmi;

import edu.uek.referral.api.request.GetExaminationListRequest;
import edu.uek.referral.api.response.GetExaminationListResponse;
import edu.uek.referral.logic.util.PropertyHandler;
import edu.uek.referral.model.entity.Examination;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by ahmed on 09.06.15.
 */
public class LaboratoryClient {

    public static void main(String[] args) {
        locateLaboratoryService();
    }

    private static void locateLaboratoryService() {
        try {
            Registry registry = LocateRegistry.getRegistry(PropertyHandler.getProperty("rmi.address"));
            Laboratory laboratory = (Laboratory) registry.lookup(PropertyHandler.getProperty("rmi.name"));

            GetExaminationListRequest request = new GetExaminationListRequest();
            request.setClientId(1234);
            GetExaminationListResponse response = laboratory.getExaminationList(request);

            for (Examination e : response.getExaminationList()) {
                System.out.println(String.format("%d\t\t%s\t\t%s\n", e.getId(), e.getCode(), e.getName()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
