package com.uninet.myumrah.model;

import java.io.Serializable;

public class ListJamaah implements Serializable{

    private String idJamaah;
    private String namaLengkap;
    private String nik;

    public String getIdJamaah() {
        return idJamaah;
    }

    public void setIdJamaah(String idJamaah) {
        this.idJamaah = idJamaah;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    @Override
    public String toString() {
        return "ListJamaah{" +
                "idJamaah='" + idJamaah + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", nik='" + nik + '\'' +
                '}';
    }
}
