package edu.uek.referral.api.response;

import edu.uek.referral.model.entity.Examination;

import java.util.List;

/**
 * Created by bmik on 2015-06-07.
 */
public class GetExaminationListResponse extends BasicResponse {

    private List<Examination> examinationList;

    public List<Examination> getExaminationList() {
        return examinationList;
    }

    public void setExaminationList(List<Examination> examinationList) {
        this.examinationList = examinationList;
    }
}
