package edu.uek.referral.api.response;

import edu.uek.referral.model.entity.Referral;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ahmed on 09.06.15.
 */
public class GetAllNewReferralsResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = -5484037326815377670L;

    private List<Referral> referralList;

    public List<Referral> getReferralList() {
        return referralList;
    }

    public void setReferralList(List<Referral> referralList) {
        this.referralList = referralList;
    }
}
