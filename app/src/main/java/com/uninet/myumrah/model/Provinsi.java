package com.uninet.myumrah.model;

import java.io.Serializable;

public class Provinsi implements Serializable{

    private String idProvinsi;
    private String namaProvinsi;


    public Provinsi(String idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(String idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    @Override
    public String toString() {
        return "Provinsi{" +
                "idProvinsi='" + idProvinsi + '\'' +
                ", namaProvinsi='" + namaProvinsi + '\'' +
                '}';
    }
}
