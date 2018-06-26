package com.uninet.myumrah.model;

import java.io.Serializable;

public class Instansi implements Serializable{

    private Integer idInstansi;
    private String namaInstansi;
    private String alamatInstansi;
    private Integer idBank;

    public Instansi() {
    }

    public Instansi(Integer idInstansi) {
        this.idInstansi = idInstansi;
    }

    public Integer getIdInstansi() {
        return idInstansi;
    }

    public void setIdInstansi(Integer idInstansi) {
        this.idInstansi = idInstansi;
    }

    public String getNamaInstansi() {
        return namaInstansi;
    }

    public void setNamaInstansi(String namaInstansi) {
        this.namaInstansi = namaInstansi;
    }

    public String getAlamatInstansi() {
        return alamatInstansi;
    }

    public void setAlamatInstansi(String alamatInstansi) {
        this.alamatInstansi = alamatInstansi;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    @Override
    public String toString() {
        return "Instansi{" +
                "idInstansi=" + idInstansi +
                ", namaInstansi='" + namaInstansi + '\'' +
                ", alamatInstansi='" + alamatInstansi + '\'' +
                ", idBank=" + idBank +
                '}';
    }
}
