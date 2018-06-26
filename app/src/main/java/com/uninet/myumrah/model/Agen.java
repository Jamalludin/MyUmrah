package com.uninet.myumrah.model;

import java.io.Serializable;
import java.util.Date;

public class Agen implements Serializable{

    private Integer totalCount;
    private Integer rowNumber;
    private String idAgen;
    private String namaAgen;
    private String tempatLahir;
    private Date tglLahir;
    private String alamatAgen;
    private Bank bank;
    private String nikAgen;
    private String rtrwAgen;
    private String emailAgen;
    private String noHpAgen;
    private String norekAgen;
    private Perwakilan perwakilan;
    private StatusAktif statusAktif;
    private User user;
    private Kelurahan kelurahan;
    private Kecamatan kecamatan;
    private KotaKabupaten kotaKabupaten;
    private Provinsi provinsi;
    private JenisKelamin jenisKelamin;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getIdAgen() {
        return idAgen;
    }

    public void setIdAgen(String idAgen) {
        this.idAgen = idAgen;
    }

    public String getNamaAgen() {
        return namaAgen;
    }

    public void setNamaAgen(String namaAgen) {
        this.namaAgen = namaAgen;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAlamatAgen() {
        return alamatAgen;
    }

    public void setAlamatAgen(String alamatAgen) {
        this.alamatAgen = alamatAgen;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getNikAgen() {
        return nikAgen;
    }

    public void setNikAgen(String nikAgen) {
        this.nikAgen = nikAgen;
    }

    public String getRtrwAgen() {
        return rtrwAgen;
    }

    public void setRtrwAgen(String rtrwAgen) {
        this.rtrwAgen = rtrwAgen;
    }

    public String getEmailAgen() {
        return emailAgen;
    }

    public void setEmailAgen(String emailAgen) {
        this.emailAgen = emailAgen;
    }

    public String getNoHpAgen() {
        return noHpAgen;
    }

    public void setNoHpAgen(String noHpAgen) {
        this.noHpAgen = noHpAgen;
    }

    public String getNorekAgen() {
        return norekAgen;
    }

    public void setNorekAgen(String norekAgen) {
        this.norekAgen = norekAgen;
    }

    public Perwakilan getPerwakilan() {
        return perwakilan;
    }

    public void setPerwakilan(Perwakilan perwakilan) {
        this.perwakilan = perwakilan;
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

    public Kelurahan getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(Kelurahan kelurahan) {
        this.kelurahan = kelurahan;
    }

    public Kecamatan getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }

    public KotaKabupaten getKotaKabupaten() {
        return kotaKabupaten;
    }

    public void setKotaKabupaten(KotaKabupaten kotaKabupaten) {
        this.kotaKabupaten = kotaKabupaten;
    }

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    @Override
    public String toString() {
        return "Agen{" +
                "totalCount=" + totalCount +
                ", rowNumber=" + rowNumber +
                ", idAgen='" + idAgen + '\'' +
                ", namaAgen='" + namaAgen + '\'' +
                ", tempatLahir='" + tempatLahir + '\'' +
                ", tglLahir=" + tglLahir +
                ", alamatAgen='" + alamatAgen + '\'' +
                ", bank=" + bank +
                ", nikAgen='" + nikAgen + '\'' +
                ", rtrwAgen='" + rtrwAgen + '\'' +
                ", emailAgen='" + emailAgen + '\'' +
                ", noHpAgen='" + noHpAgen + '\'' +
                ", norekAgen='" + norekAgen + '\'' +
                ", perwakilan=" + perwakilan +
                ", statusAktif=" + statusAktif +
                ", user=" + user +
                ", kelurahan=" + kelurahan +
                ", kecamatan=" + kecamatan +
                ", kotaKabupaten=" + kotaKabupaten +
                ", provinsi=" + provinsi +
                ", jenisKelamin=" + jenisKelamin +
                '}';
    }
}
