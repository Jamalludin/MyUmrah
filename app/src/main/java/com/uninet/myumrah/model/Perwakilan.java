package com.uninet.myumrah.model;

import java.io.Serializable;
import java.util.Date;

public class Perwakilan implements Serializable{

    private String idPerwakilan;
    private String namaPerwakilan;
    private java.util.Date tglBerdiri;
    private Bank bank;
    private String nikPerwakilan;
    private String noHpPerwakilan;
    private String emailPerwakilan;
    private String norekPerwakilan;
    private StatusAktif statusAktif;
    private User user;
    private TipePerwakilan tipe;
    private String alamatPerwakilan;
    private String rtrwPerwakilan;
    private Kelurahan kelurahanPerwakilan;
    private Kecamatan kecamatanPerwakilan;
    private KotaKabupaten kotaKabupatenPerwakilan;
    private Provinsi provinsiPerwakilan;
    private String alamatSendiri;
    private String rtrwSendiri;
    private Kelurahan kelurahanSendiri;
    private Kecamatan kecamatanSendiri;
    private KotaKabupaten kotaKabupatenSendiri;
    private Provinsi provinsiSendiri;
    private java.util.Date tglDaftar;
    private JenisKelamin jenisKelamin;

    public String getIdPerwakilan() {
        return idPerwakilan;
    }

    public void setIdPerwakilan(String idPerwakilan) {
        this.idPerwakilan = idPerwakilan;
    }

    public String getNamaPerwakilan() {
        return namaPerwakilan;
    }

    public void setNamaPerwakilan(String namaPerwakilan) {
        this.namaPerwakilan = namaPerwakilan;
    }

    public Date getTglBerdiri() {
        return tglBerdiri;
    }

    public void setTglBerdiri(Date tglBerdiri) {
        this.tglBerdiri = tglBerdiri;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getNikPerwakilan() {
        return nikPerwakilan;
    }

    public void setNikPerwakilan(String nikPerwakilan) {
        this.nikPerwakilan = nikPerwakilan;
    }

    public String getNoHpPerwakilan() {
        return noHpPerwakilan;
    }

    public void setNoHpPerwakilan(String noHpPerwakilan) {
        this.noHpPerwakilan = noHpPerwakilan;
    }

    public String getEmailPerwakilan() {
        return emailPerwakilan;
    }

    public void setEmailPerwakilan(String emailPerwakilan) {
        this.emailPerwakilan = emailPerwakilan;
    }

    public String getNorekPerwakilan() {
        return norekPerwakilan;
    }

    public void setNorekPerwakilan(String norekPerwakilan) {
        this.norekPerwakilan = norekPerwakilan;
    }

    public StatusAktif getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(StatusAktif statusAktif) {
        this.statusAktif = statusAktif;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TipePerwakilan getTipe() {
        return tipe;
    }

    public void setTipe(TipePerwakilan tipe) {
        this.tipe = tipe;
    }

    public String getAlamatPerwakilan() {
        return alamatPerwakilan;
    }

    public void setAlamatPerwakilan(String alamatPerwakilan) {
        this.alamatPerwakilan = alamatPerwakilan;
    }

    public String getRtrwPerwakilan() {
        return rtrwPerwakilan;
    }

    public void setRtrwPerwakilan(String rtrwPerwakilan) {
        this.rtrwPerwakilan = rtrwPerwakilan;
    }

    public Kelurahan getKelurahanPerwakilan() {
        return kelurahanPerwakilan;
    }

    public void setKelurahanPerwakilan(Kelurahan kelurahanPerwakilan) {
        this.kelurahanPerwakilan = kelurahanPerwakilan;
    }

    public Kecamatan getKecamatanPerwakilan() {
        return kecamatanPerwakilan;
    }

    public void setKecamatanPerwakilan(Kecamatan kecamatanPerwakilan) {
        this.kecamatanPerwakilan = kecamatanPerwakilan;
    }

    public KotaKabupaten getKotaKabupatenPerwakilan() {
        return kotaKabupatenPerwakilan;
    }

    public void setKotaKabupatenPerwakilan(KotaKabupaten kotaKabupatenPerwakilan) {
        this.kotaKabupatenPerwakilan = kotaKabupatenPerwakilan;
    }

    public Provinsi getProvinsiPerwakilan() {
        return provinsiPerwakilan;
    }

    public void setProvinsiPerwakilan(Provinsi provinsiPerwakilan) {
        this.provinsiPerwakilan = provinsiPerwakilan;
    }

    public String getAlamatSendiri() {
        return alamatSendiri;
    }

    public void setAlamatSendiri(String alamatSendiri) {
        this.alamatSendiri = alamatSendiri;
    }

    public String getRtrwSendiri() {
        return rtrwSendiri;
    }

    public void setRtrwSendiri(String rtrwSendiri) {
        this.rtrwSendiri = rtrwSendiri;
    }

    public Kelurahan getKelurahanSendiri() {
        return kelurahanSendiri;
    }

    public void setKelurahanSendiri(Kelurahan kelurahanSendiri) {
        this.kelurahanSendiri = kelurahanSendiri;
    }

    public Kecamatan getKecamatanSendiri() {
        return kecamatanSendiri;
    }

    public void setKecamatanSendiri(Kecamatan kecamatanSendiri) {
        this.kecamatanSendiri = kecamatanSendiri;
    }

    public KotaKabupaten getKotaKabupatenSendiri() {
        return kotaKabupatenSendiri;
    }

    public void setKotaKabupatenSendiri(KotaKabupaten kotaKabupatenSendiri) {
        this.kotaKabupatenSendiri = kotaKabupatenSendiri;
    }

    public Provinsi getProvinsiSendiri() {
        return provinsiSendiri;
    }

    public void setProvinsiSendiri(Provinsi provinsiSendiri) {
        this.provinsiSendiri = provinsiSendiri;
    }

    public Date getTglDaftar() {
        return tglDaftar;
    }

    public void setTglDaftar(Date tglDaftar) {
        this.tglDaftar = tglDaftar;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    @Override
    public String toString() {
        return "Perwakilan{" +
                "idPerwakilan='" + idPerwakilan + '\'' +
                ", namaPerwakilan='" + namaPerwakilan + '\'' +
                ", tglBerdiri=" + tglBerdiri +
                ", bank=" + bank +
                ", nikPerwakilan='" + nikPerwakilan + '\'' +
                ", noHpPerwakilan='" + noHpPerwakilan + '\'' +
                ", emailPerwakilan='" + emailPerwakilan + '\'' +
                ", norekPerwakilan='" + norekPerwakilan + '\'' +
                ", statusAktif=" + statusAktif +
                ", user=" + user +
                ", tipe=" + tipe +
                ", alamatPerwakilan='" + alamatPerwakilan + '\'' +
                ", rtrwPerwakilan='" + rtrwPerwakilan + '\'' +
                ", kelurahanPerwakilan=" + kelurahanPerwakilan +
                ", kecamatanPerwakilan=" + kecamatanPerwakilan +
                ", kotaKabupatenPerwakilan=" + kotaKabupatenPerwakilan +
                ", provinsiPerwakilan=" + provinsiPerwakilan +
                ", alamatSendiri='" + alamatSendiri + '\'' +
                ", rtrwSendiri='" + rtrwSendiri + '\'' +
                ", kelurahanSendiri=" + kelurahanSendiri +
                ", kecamatanSendiri=" + kecamatanSendiri +
                ", kotaKabupatenSendiri=" + kotaKabupatenSendiri +
                ", provinsiSendiri=" + provinsiSendiri +
                ", tglDaftar=" + tglDaftar +
                ", jenisKelamin=" + jenisKelamin +
                '}';
    }
}
