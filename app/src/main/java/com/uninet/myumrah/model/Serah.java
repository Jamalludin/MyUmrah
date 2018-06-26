package com.uninet.myumrah.model;

import java.io.Serializable;

public class Serah implements Serializable{

    private Integer idSerah;
    private String namaSerah;

    public Integer getIdSerah() {
        return idSerah;
    }

    public void setIdSerah(Integer idSerah) {
        this.idSerah = idSerah;
    }

    public String getNamaSerah() {
        return namaSerah;
    }

    public void setNamaSerah(String namaSerah) {
        this.namaSerah = namaSerah;
    }

    @Override
    public String toString() {
        return "Serah{" +
                "idSerah=" + idSerah +
                ", namaSerah='" + namaSerah + '\'' +
                '}';
    }
}
