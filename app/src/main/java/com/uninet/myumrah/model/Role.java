package com.uninet.myumrah.model;

import java.io.Serializable;

public class Role implements Serializable{

    private Long idRole;
    private String namaRole;
    private String keterangan;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", namaRole='" + namaRole + '\'' +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
