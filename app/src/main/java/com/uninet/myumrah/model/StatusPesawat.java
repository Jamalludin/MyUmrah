package com.uninet.myumrah.model;

import java.io.Serializable;

public class StatusPesawat implements Serializable{

    private Integer idStatusPesawat;
    private String namaStatusPesawat;

    public Integer getIdStatusPesawat() {
        return idStatusPesawat;
    }

    public void setIdStatusPesawat(Integer idStatusPesawat) {
        this.idStatusPesawat = idStatusPesawat;
    }

    public String getNamaStatusPesawat() {
        return namaStatusPesawat;
    }

    public void setNamaStatusPesawat(String namaStatusPesawat) {
        this.namaStatusPesawat = namaStatusPesawat;
    }

    @Override
    public String toString() {
        return "StatusPesawat{" +
                "idStatusPesawat=" + idStatusPesawat +
                ", namaStatusPesawat='" + namaStatusPesawat + '\'' +
                '}';
    }
}
