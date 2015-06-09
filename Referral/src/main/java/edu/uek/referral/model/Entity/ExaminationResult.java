package edu.uek.referral.model.entity;

import java.io.Serializable;

/**
 * Created by bmik on 2015-06-02.
 */
public class ExaminationResult implements Serializable {

    private static final long serialVersionUID = -7399895212320810340L;

    private long id;
    private long referralId;
    private String parameterName;
    private String parameterValue;
    private String parameterUnit;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getParameterUnit() {
        return parameterUnit;
    }

    public void setParameterUnit(String parameterUnit) {
        this.parameterUnit = parameterUnit;
    }

    public long getReferralId() {
        return referralId;
    }

    public void setReferralId(long referralId) {
        this.referralId = referralId;
    }
}
