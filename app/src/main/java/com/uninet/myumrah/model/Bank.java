package com.uninet.myumrah.model;

import java.io.Serializable;

public class Bank implements Serializable{

    private Integer idBank;
    private String namaBank;
    private Integer statusSyariah;

    public Bank(Integer idBank) {
        this.idBank = idBank;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public Integer getStatusSyariah() {
        return statusSyariah;
    }

    public void setStatusSyariah(Integer statusSyariah) {
        this.statusSyariah = statusSyariah;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "idBank=" + idBank +
                ", namaBank='" + namaBank + '\'' +
                ", statusSyariah=" + statusSyariah +
                '}';
    }
}
