package edu.uek.referral.api.response;

import edu.uek.referral.model.entity.Referral;

import java.io.Serializable;

/**
 * Created by ahmed on 09.06.15.
 */
public class GetReferralByCodeResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 4134098161518175423L;

    private Referral referral;

    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }
}
