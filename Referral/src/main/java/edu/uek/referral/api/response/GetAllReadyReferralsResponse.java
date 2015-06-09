package edu.uek.referral.api.response;

import edu.uek.referral.model.entity.Referral;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bmik on 2015-06-07.
 */
public class GetAllReadyReferralsResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 1303610723235429396L;

    private List<Referral> referralList;

    public List<Referral> getReferralList() {
        return referralList;
    }

    public void setReferralList(List<Referral> referralList) {
        this.referralList = referralList;
    }
}
