package com.uninet.myumrah.model;

import java.io.Serializable;

public class Hubungan implements Serializable {

    private Integer idHubungan;
    private String namaHubungan;

    public Hubungan(Integer idHubungan) {
        this.idHubungan = idHubungan;
    }

    public Integer getIdHubungan() {
        return idHubungan;
    }

    public void setIdHubungan(Integer idHubungan) {
        this.idHubungan = idHubungan;
    }

    public String getNamaHubungan() {
        return namaHubungan;
    }

    public void setNamaHubungan(String namaHubungan) {
        this.namaHubungan = namaHubungan;
    }

    @Override
    public String toString() {
        return "Hubungan{" +
                "idHubungan=" + idHubungan +
                ", namaHubungan='" + namaHubungan + '\'' +
                '}';
    }
}
