package edu.uek.referral.api.response;

import edu.uek.referral.api.ResponseStatus;

/**
 * Created by bmik on 2015-06-06.
 */
public class BasicResponse {

    private ResponseStatus status;
    private String cause;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
