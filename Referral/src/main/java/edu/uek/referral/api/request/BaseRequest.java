package edu.uek.referral.api.request;

import java.io.Serializable;

/**
 * Created by ahmed on 09.06.15.
 */
public class BaseRequest {

    private long clientId;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
