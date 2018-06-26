package com.uninet.myumrah.model;

import java.io.Serializable;

public class TipePerwakilan implements Serializable{

    private Integer idTipe;
    private String namaTipe;

    public Integer getIdTipe() {
        return idTipe;
    }

    public void setIdTipe(Integer idTipe) {
        this.idTipe = idTipe;
    }

    public String getNamaTipe() {
        return namaTipe;
    }

    public void setNamaTipe(String namaTipe) {
        this.namaTipe = namaTipe;
    }

    @Override
    public String toString() {
        return "TipePerwakilan{" +
                "idTipe=" + idTipe +
                ", namaTipe='" + namaTipe + '\'' +
                '}';
    }
}
