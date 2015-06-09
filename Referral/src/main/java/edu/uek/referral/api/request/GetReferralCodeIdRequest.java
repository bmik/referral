package edu.uek.referral.api.request;

import java.io.Serializable;

/**
 * Created by ahmed on 09.06.15.
 */
public class GetReferralCodeIdRequest extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 5427705787921608364L;

    private String referralCode;

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
}
