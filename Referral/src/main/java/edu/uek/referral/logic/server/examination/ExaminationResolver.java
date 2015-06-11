package edu.uek.referral.logic.server.examination;

import edu.uek.referral.api.ResponseStatus;
import edu.uek.referral.api.request.GetAllNewReferralsRequest;
import edu.uek.referral.api.request.SetExaminationResultsRequest;
import edu.uek.referral.api.response.GetAllNewReferralsResponse;
import edu.uek.referral.api.response.SetExaminationResultsResponse;
import edu.uek.referral.logic.server.LaboratoryService;
import edu.uek.referral.model.entity.ExaminationResult;
import edu.uek.referral.model.entity.Referral;
import edu.uek.referral.model.repository.ReferralRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bmik on 2015-06-10.
 */
public class ExaminationResolver extends Thread {

    @Override
    public void run() {
        LaboratoryService service = new LaboratoryService();

        while(true) {
            try {
                sleep(5000);

                GetAllNewReferralsRequest request = new GetAllNewReferralsRequest();
                GetAllNewReferralsResponse response = service.getAllNewReferrals(request);

                sleep((int) (Math.random() * 10000 ));

                List<Referral> referralsForExamination = filterList(response.getReferralList());
                List<ExaminationResult> examinationResults = prepareExaminationResults(referralsForExamination);

                SetExaminationResultsRequest setExaminationResultsRequest = new SetExaminationResultsRequest();
                setExaminationResultsRequest.setExaminationResultList(examinationResults);
                SetExaminationResultsResponse setExaminationResultsResponse = service.setExaminationResults(setExaminationResultsRequest);

                if(ResponseStatus.INVALID.equals(setExaminationResultsResponse.getStatus()) == true) {
                    System.out.println(String.format("Problem with setting examination results: %s", response.getCause()));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private List<Referral> filterList(List<Referral> referrals) {
        List<Referral> referralsForExamination = new ArrayList<Referral>();

        for (Referral r : referrals) {
            if (0.5 < Math.random()) {
                referralsForExamination.add(r);
            }
        }

        return referralsForExamination;
    }

    private List<ExaminationResult> prepareExaminationResults(List<Referral> referrals) {
        List<ExaminationResult> results = new ArrayList<ExaminationResult>();

        for (Referral r : referrals) {
            ExaminationResult result = new ExaminationResult();

            result.setReferralId(r.getId());

            int nameIndex = (int) (Math.random() * ExaminationParameter.getParameterNamesSize());
            result.setParameterName(ExaminationParameter.getParameterName(nameIndex));

            result.setParameterValue( String.valueOf(Math.random() * 100) );

            int unitIndex = (int) (Math.random() * ExaminationParameter.getParameterUnitsSize());
            result.setParameterUnit(ExaminationParameter.getParameterUnit(unitIndex));

            results.add(result);
        }

        return results;
    }

}
