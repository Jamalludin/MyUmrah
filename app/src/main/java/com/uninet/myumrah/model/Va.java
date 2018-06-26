package com.uninet.myumrah.model;

import java.io.Serializable;

public class Va implements Serializable{

    private String idVa;
    private String namaVa;

    public String getIdVa() {
        return idVa;
    }

    public void setIdVa(String idVa) {
        this.idVa = idVa;
    }

    public String getNamaVa() {
        return namaVa;
    }

    public void setNamaVa(String namaVa) {
        this.namaVa = namaVa;
    }

    @Override
    public String toString() {
        return "Va{" +
                "idVa='" + idVa + '\'' +
                ", namaVa='" + namaVa + '\'' +
                '}';
    }
}
