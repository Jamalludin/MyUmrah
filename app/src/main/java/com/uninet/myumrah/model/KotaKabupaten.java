package com.uninet.myumrah.model;

public class KotaKabupaten {

    private String idKabupaten;
    private String namaKabupaten;
    private Provinsi provinsi;

    public String getIdKabupaten() {
        return idKabupaten;
    }

    public void setIdKabupaten(String idKabupaten) {
        this.idKabupaten = idKabupaten;
    }

    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
    }

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    @Override
    public String toString() {
        return "KotaKabupaten{" +
                "idKabupaten='" + idKabupaten + '\'' +
                ", namaKabupaten='" + namaKabupaten + '\'' +
                ", provinsi=" + provinsi +
                '}';
    }
}
