package com.uninet.myumrah.model;

import java.io.Serializable;

public class StatusKawin implements Serializable{

    private Integer idStatusKawin;
    private String namaStatus;

    public StatusKawin(Integer idStatusKawin) {
        this.idStatusKawin = idStatusKawin;
    }

    public Integer getIdStatusKawin() {
        return idStatusKawin;
    }

    public void setIdStatusKawin(Integer idStatusKawin) {
        this.idStatusKawin = idStatusKawin;
    }

    public String getNamaStatus() {
        return namaStatus;
    }

    public void setNamaStatus(String namaStatus) {
        this.namaStatus = namaStatus;
    }

    @Override
    public String toString() {
        return "StatusKawin{" +
                "idStatusKawin=" + idStatusKawin +
                ", namaStatus='" + namaStatus + '\'' +
                '}';
    }
}
