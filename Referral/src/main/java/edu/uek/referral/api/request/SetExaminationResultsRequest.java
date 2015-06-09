package edu.uek.referral.api.request;

import edu.uek.referral.model.entity.ExaminationResult;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ahmed on 09.06.15.
 */
public class SetExaminationResultsRequest extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 5615665195757307833L;

    private List<ExaminationResult> examinationResultList;

    public List<ExaminationResult> getExaminationResultList() {
        return examinationResultList;
    }

    public void setExaminationResultList(List<ExaminationResult> examinationResultList) {
        this.examinationResultList = examinationResultList;
    }
}
