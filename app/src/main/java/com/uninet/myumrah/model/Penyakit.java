package com.uninet.myumrah.model;

import java.io.Serializable;

public class Penyakit implements Serializable{

    private Integer idPenyakit;
    private String namaPenyakit;
    private Integer idStatus;

    public Integer getIdPenyakit() {
        return idPenyakit;
    }

    public void setIdPenyakit(Integer idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public String toString() {
        return "Penyakit{" +
                "idPenyakit=" + idPenyakit +
                ", namaPenyakit='" + namaPenyakit + '\'' +
                ", idStatus=" + idStatus +
                '}';
    }
}
