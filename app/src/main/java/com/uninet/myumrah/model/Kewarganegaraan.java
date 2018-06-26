package com.uninet.myumrah.model;

import java.io.Serializable;

public class Kewarganegaraan implements Serializable{

    private Integer idKewarganegaraan;
    private String namaKewarganegaraan;

    public Kewarganegaraan(Integer idKewarganegaraan) {
        this.idKewarganegaraan = idKewarganegaraan;
    }

    public Integer getIdKewarganegaraan() {
        return idKewarganegaraan;
    }

    public void setIdKewarganegaraan(Integer idKewarganegaraan) {
        this.idKewarganegaraan = idKewarganegaraan;
    }

    public String getNamaKewarganegaraan() {
        return namaKewarganegaraan;
    }

    public void setNamaKewarganegaraan(String namaKewarganegaraan) {
        this.namaKewarganegaraan = namaKewarganegaraan;
    }

    @Override
    public String toString() {
        return "Kewarganegaraan{" +
                "idKewarganegaraan=" + idKewarganegaraan +
                ", namaKewarganegaraan='" + namaKewarganegaraan + '\'' +
                '}';
    }
}
