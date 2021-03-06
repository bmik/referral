package edu.uek.referral.api.request;

import edu.uek.referral.model.entity.Referral;

import java.io.Serializable;

/**
 * Created by bmik on 2015-06-06.
 */
public class AddNewReferralRequest extends BaseRequest implements Serializable {

    private static final long serialVersionUID = -480540358927975878L;

    private Referral referral;

    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }
}
