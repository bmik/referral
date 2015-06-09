package edu.uek.referral.model.entity;

import edu.uek.referral.api.ReferralStatus;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bmik on 2015-06-02.
 */
public class Referral implements Serializable {

    private static final long serialVersionUID = 2745867997314062601L;

    private long id;
    private long clientId;
    private String referralCode;
    private Date createDate;
    private Date examinationDate;
    private Examination examination;
    private ExaminationResult examinationResult;
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

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public ReferralStatus getStatus() {
        return status;
    }

    public void setStatus(ReferralStatus status) {
        this.status = status;
    }

    public ExaminationResult getExaminationResult() {
        return examinationResult;
    }

    public void setExaminationResult(ExaminationResult examinationResult) {
        this.examinationResult = examinationResult;
    }
}
