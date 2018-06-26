package com.uninet.myumrah.model;

import java.io.Serializable;

public class Pendidikan implements Serializable{

    private Integer idPendidikan;
    private String namaPendidikan;

    public Pendidikan(Integer idPendidikan) {
        this.idPendidikan = idPendidikan;
    }

    public Integer getIdPendidikan() {
        return idPendidikan;
    }

    public void setIdPendidikan(Integer idPendidikan) {
        this.idPendidikan = idPendidikan;
    }

    public String getNamaPendidikan() {
        return namaPendidikan;
    }

    public void setNamaPendidikan(String namaPendidikan) {
        this.namaPendidikan = namaPendidikan;
    }

    @Override
    public String toString() {
        return "Pendidikan{" +
                "idPendidikan=" + idPendidikan +
                ", namaPendidikan='" + namaPendidikan + '\'' +
                '}';
    }
}
