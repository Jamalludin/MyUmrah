package com.uninet.myumrah.model;

import java.io.Serializable;

public class JenisKelamin implements Serializable{

    private Integer idJenisKelamin;
    private String namaJenisKelamin;

    public JenisKelamin() {
    }

    public JenisKelamin(String namaJenisKelamin) {
        this.namaJenisKelamin = namaJenisKelamin;
    }

    public JenisKelamin(Integer idJenisKelamin) {
        this.idJenisKelamin = idJenisKelamin;
    }

    public Integer getIdJenisKelamin() {
        return idJenisKelamin;
    }

    public void setIdJenisKelamin(Integer idJenisKelamin) {
        this.idJenisKelamin = idJenisKelamin;
    }

    public String getNamaJenisKelamin() {
        return namaJenisKelamin;
    }

    public void setNamaJenisKelamin(String namaJenisKelamin) {
        this.namaJenisKelamin = namaJenisKelamin;
    }

    @Override
    public String toString() {
        return "JenisKelamin{" +
                "idJenisKelamin=" + idJenisKelamin +
                ", namaJenisKelamin='" + namaJenisKelamin + '\'' +
                '}';
    }
}
