package com.uninet.myumrah.model;

import java.io.Serializable;

public class Ukuran implements Serializable{

    private Integer idUkuran;
    private String namaUkuran;

    public Ukuran(Integer idUkuran) {
        this.idUkuran = idUkuran;
    }

    public Integer getIdUkuran() {
        return idUkuran;
    }

    public void setIdUkuran(Integer idUkuran) {
        this.idUkuran = idUkuran;
    }

    public String getNamaUkuran() {
        return namaUkuran;
    }

    public void setNamaUkuran(String namaUkuran) {
        this.namaUkuran = namaUkuran;
    }

    @Override
    public String toString() {
        return "Ukuran{" +
                "idUkuran=" + idUkuran +
                ", namaUkuran='" + namaUkuran + '\'' +
                '}';
    }
}
