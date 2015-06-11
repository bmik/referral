package edu.uek.referral.rmi;

import edu.uek.referral.logic.server.examination.ExaminationResolver;
import edu.uek.referral.logic.util.PropertyHandler;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by bmik on 2015-06-06.
 */
public class LaboratoryServer {

    public static void main(String[] args) {
        registerRmiService();
        startExaminationResolver();

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

    private static void startExaminationResolver() {
        ExaminationResolver examinationResolver = new ExaminationResolver();
        examinationResolver.run();
    }

}
