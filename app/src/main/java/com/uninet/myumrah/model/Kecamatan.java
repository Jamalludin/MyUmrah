package com.uninet.myumrah.model;

import java.io.Serializable;

public class Kecamatan implements Serializable {

    private String idKecamatan;
    private String namaKecamatan;
    private KotaKabupaten kotaKabupaten;

    public Kecamatan(String idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(String idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public KotaKabupaten getKotaKabupaten() {
        return kotaKabupaten;
    }

    public void setKotaKabupaten(KotaKabupaten kotaKabupaten) {
        this.kotaKabupaten = kotaKabupaten;
    }

    @Override
    public String toString() {
        return "Kecamatan{" +
                "idKecamatan='" + idKecamatan + '\'' +
                ", namaKecamatan='" + namaKecamatan + '\'' +
                ", kotaKabupaten=" + kotaKabupaten +
                '}';
    }
}
