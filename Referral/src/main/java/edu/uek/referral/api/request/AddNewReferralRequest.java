package edu.uek.referral.api.request;

import edu.uek.referral.model.entity.Referral;

/**
 * Created by bmik on 2015-06-06.
 */
public class AddNewReferralRequest {

    private long clientID;
    private Referral referral;

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }
}
