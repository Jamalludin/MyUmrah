package com.uninet.myumrah.model;

import java.io.Serializable;

public class JenisBayar implements Serializable {

    private Integer idJenisBayar;
    private String namaJenisBayar;

    public JenisBayar(Integer idJenisBayar) {
        this.idJenisBayar = idJenisBayar;
    }

    public Integer getIdJenisBayar() {
        return idJenisBayar;
    }

    public void setIdJenisBayar(Integer idJenisBayar) {
        this.idJenisBayar = idJenisBayar;
    }

    public String getNamaJenisBayar() {
        return namaJenisBayar;
    }

    public void setNamaJenisBayar(String namaJenisBayar) {
        this.namaJenisBayar = namaJenisBayar;
    }

    @Override
    public String toString() {
        return "JenisBayar{" +
                "idJenisBayar=" + idJenisBayar +
                ", namaJenisBayar='" + namaJenisBayar + '\'' +
                '}';
    }
}
