package edu.uek.referral.model.entity;

import java.io.Serializable;

/**
 * Created by bmik on 2015-06-02.
 */
public class Examination implements Serializable {

    private static final long serialVersionUID = 5899494286611401429L;

    private long id;
    private String code;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
