package edu.uek.referral.api.response;

import edu.uek.referral.model.entity.Examination;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bmik on 2015-06-07.
 */
public class GetExaminationListResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = -2389221553696644194L;

    private List<Examination> examinationList;

    public List<Examination> getExaminationList() {
        return examinationList;
    }

    public void setExaminationList(List<Examination> examinationList) {
        this.examinationList = examinationList;
    }
}
