package com.uninet.myumrah.model;

import java.io.Serializable;

public class Kelurahan implements Serializable {

    private String idKelurahan;
    private String namaKelurahan;
    private String kodePos;
    private Provinsi provinsi;
    private KotaKabupaten kotaKabupaten;
    private Kecamatan kecamatan;

    public Kelurahan(String idKelurahan, String kodePos) {
        this.idKelurahan = idKelurahan;
        this.kodePos = kodePos;
    }

    public String getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(String idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    public KotaKabupaten getKotaKabupaten() {
        return kotaKabupaten;
    }

    public void setKotaKabupaten(KotaKabupaten kotaKabupaten) {
        this.kotaKabupaten = kotaKabupaten;
    }

    public Kecamatan getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }

    @Override
    public String toString() {
        return "Kelurahan{" +
                "idKelurahan='" + idKelurahan + '\'' +
                ", namaKelurahan='" + namaKelurahan + '\'' +
                ", kodePos='" + kodePos + '\'' +
                ", provinsi=" + provinsi +
                ", kotaKabupaten=" + kotaKabupaten +
                ", kecamatan=" + kecamatan +
                '}';
    }
}
