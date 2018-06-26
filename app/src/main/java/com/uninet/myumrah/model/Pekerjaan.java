package com.uninet.myumrah.model;

import java.io.Serializable;

public class Pekerjaan implements Serializable{

    private Integer idPekerjaan;
    private String namaPekerjaan;

    public Pekerjaan(Integer idPekerjaan) {
        this.idPekerjaan = idPekerjaan;
    }

    public Integer getIdPekerjaan() {
        return idPekerjaan;
    }

    public void setIdPekerjaan(Integer idPekerjaan) {
        this.idPekerjaan = idPekerjaan;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    @Override
    public String toString() {
        return "Pekerjaan{" +
                "idPekerjaan=" + idPekerjaan +
                ", namaPekerjaan='" + namaPekerjaan + '\'' +
                '}';
    }
}
