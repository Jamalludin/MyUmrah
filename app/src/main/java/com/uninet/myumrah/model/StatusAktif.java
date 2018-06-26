package com.uninet.myumrah.model;

import java.io.Serializable;

public class StatusAktif implements Serializable{

    private Integer idStatusAktif;
    private String namaStatusAktif;

    public Integer getIdStatusAktif() {
        return idStatusAktif;
    }

    public void setIdStatusAktif(Integer idStatusAktif) {
        this.idStatusAktif = idStatusAktif;
    }

    public String getNamaStatusAktif() {
        return namaStatusAktif;
    }

    public void setNamaStatusAktif(String namaStatusAktif) {
        this.namaStatusAktif = namaStatusAktif;
    }

    @Override
    public String toString() {
        return "StatusAktif{" +
                "idStatusAktif=" + idStatusAktif +
                ", namaStatusAktif='" + namaStatusAktif + '\'' +
                '}';
    }
}
