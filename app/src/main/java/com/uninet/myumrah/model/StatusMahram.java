package com.uninet.myumrah.model;

import java.io.Serializable;

public class StatusMahram implements Serializable{

    private Integer idStatusMahram;
    private String namaStatus;

    public StatusMahram(Integer idStatusMahram) {
        this.idStatusMahram = idStatusMahram;
    }

    public Integer getIdStatusMahram() {
        return idStatusMahram;
    }

    public void setIdStatusMahram(Integer idStatusMahram) {
        this.idStatusMahram = idStatusMahram;
    }

    public String getNamaStatus() {
        return namaStatus;
    }

    public void setNamaStatus(String namaStatus) {
        this.namaStatus = namaStatus;
    }

    @Override
    public String toString() {
        return "StatusMahram{" +
                "idStatusMahram=" + idStatusMahram +
                ", namaStatus='" + namaStatus + '\'' +
                '}';
    }
}
