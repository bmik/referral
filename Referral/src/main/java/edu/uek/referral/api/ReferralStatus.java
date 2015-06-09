package edu.uek.referral.api;

/**
 * Created by bmik on 2015-06-07.
 */
public enum ReferralStatus {
    NEW,WAITING,READY,COLLECTED;

    public static ReferralStatus getByName(String name) {

        ReferralStatus status = null;

        for (ReferralStatus s : ReferralStatus.values()) {
            if (s.toString().equals(name)) {
                status = s;
            }
        }

        if (status == null) {
            throw new RuntimeException("Status not found!");
        }

        return status;

    }
}
