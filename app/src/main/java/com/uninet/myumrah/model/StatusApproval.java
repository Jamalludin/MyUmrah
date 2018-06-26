package com.uninet.myumrah.model;

import java.io.Serializable;

public class StatusApproval implements Serializable {

    private Integer idStatus;
    private String namaStatus;

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getNamaStatus() {
        return namaStatus;
    }

    public void setNamaStatus(String namaStatus) {
        this.namaStatus = namaStatus;
    }

    @Override
    public String toString() {
        return "StatusApproval{" +
                "idStatus=" + idStatus +
                ", namaStatus='" + namaStatus + '\'' +
                '}';
    }
}
