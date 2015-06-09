package edu.uek.referral.model.entity;

import edu.uek.referral.api.ReferralStatus;

import java.util.Date;

/**
 * Created by bmik on 2015-06-02.
 */
public class Referral {

    private long id;
    private long clientId;
    private String referralCode;
    private Date createDate;
    private Date examinationDate;
    private Examination examintation;
    private ReferralStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

    public Examination getExamintation() {
        return examintation;
    }

    public void setExamintation(Examination examintation) {
        this.examintation = examintation;
    }

    public ReferralStatus getStatus() {
        return status;
    }

    public void setStatus(ReferralStatus status) {
        this.status = status;
    }
}
