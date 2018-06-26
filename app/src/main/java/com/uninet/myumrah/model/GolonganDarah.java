package com.uninet.myumrah.model;

import java.io.Serializable;

public class GolonganDarah implements Serializable{

    private Integer idGolDarah;
    private String namaGolDarah;

    public GolonganDarah(Integer idGolDarah) {
        this.idGolDarah = idGolDarah;
    }

    public Integer getIdGolDarah() {
        return idGolDarah;
    }

    public void setIdGolDarah(Integer idGolDarah) {
        this.idGolDarah = idGolDarah;
    }

    public String getNamaGolDarah() {
        return namaGolDarah;
    }

    public void setNamaGolDarah(String namaGolDarah) {
        this.namaGolDarah = namaGolDarah;
    }

    @Override
    public String toString() {
        return "GolonganDarah{" +
                "idGolDarah=" + idGolDarah +
                ", namaGolDarah='" + namaGolDarah + '\'' +
                '}';
    }
}
