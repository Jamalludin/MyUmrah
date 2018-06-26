package com.uninet.myumrah.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jamaah implements Serializable{

    private String idJamaah;
    private String idCard;
    private String namaLengkap;
    private String namaAyah;
    private String nik;
    private String kk;
    private String nip;
    private String tempatLahir;
    private Date tglLahir;
    private String alamat;
    private String rtrw;
    private Kelurahan kelurahan;
    private String email;
    private GolonganDarah golonganDarah;
    private Kewarganegaraan kewarganegaraan;
    private Integer terakhirUmroh;
    private String noHp;
    private String namaDarurat;
    private String noHpDarurat;
    private String alamatDarurat;
    private Date tglDaftar;
    private Agen agen;
    private JadwalManasik jadwalManasik;
    private Paket paket;
    private StatusKawin statusKawin;
    private JenisKelamin jenisKelamin;
    private User user;
    private Provinsi provinsi;
    private KotaKabupaten kotaKabupaten;
    private Kecamatan kecamatan;
    private Pendidikan pendidikan;
    private Pekerjaan pekerjaan;
    private String noRek;
    private Cicilan cicilan;
    private DownPayment downPayment;
    private Talangan talangan;
    private Ukuran ukuran;
    private Hubungan hubungan;
    private String noVisa;
    private Date tglTerbitVisa;
    private Integer durasiVisa;
    private String noPasspor;
    private Date tglTerbitPasspor;
    private Date tglHabisPasspor;
    private String ktrTerbitPasspor;
    private StatusMahram statusMahram;
    private String namaMahram;
    private Bank bank;
    private StatusAktif statusAktif;
    private JenisBayar jenisBayar;
    private Va va;
    private JamaahApproval jamaahApproval;
    private StatusPesawat statusPesawat;
    private List<JamaahPenyakit> jamaahPenyakits = new ArrayList<>();
    private List<Dokumen> dokumens = new ArrayList<>();
    private Instansi instansi;

    public Jamaah() {
    }

    public Jamaah(String noRek) {
        this.noRek = noRek;
    }

    public String getIdJamaah() {
        return idJamaah;
    }

    public void setIdJamaah(String idJamaah) {
        this.idJamaah = idJamaah;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRtrw() {
        return rtrw;
    }

    public void setRtrw(String rtrw) {
        this.rtrw = rtrw;
    }

    public Kelurahan getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(Kelurahan kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GolonganDarah getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(GolonganDarah golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public Kewarganegaraan getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(Kewarganegaraan kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public Integer getTerakhirUmroh() {
        return terakhirUmroh;
    }

    public void setTerakhirUmroh(Integer terakhirUmroh) {
        this.terakhirUmroh = terakhirUmroh;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNamaDarurat() {
        return namaDarurat;
    }

    public void setNamaDarurat(String namaDarurat) {
        this.namaDarurat = namaDarurat;
    }

    public String getNoHpDarurat() {
        return noHpDarurat;
    }

    public void setNoHpDarurat(String noHpDarurat) {
        this.noHpDarurat = noHpDarurat;
    }

    public String getAlamatDarurat() {
        return alamatDarurat;
    }

    public void setAlamatDarurat(String alamatDarurat) {
        this.alamatDarurat = alamatDarurat;
    }

    public Date getTglDaftar() {
        return tglDaftar;
    }

    public void setTglDaftar(Date tglDaftar) {
        this.tglDaftar = tglDaftar;
    }

    public Agen getAgen() {
        return agen;
    }

    public void setAgen(Agen agen) {
        this.agen = agen;
    }

    public JadwalManasik getJadwalManasik() {
        return jadwalManasik;
    }

    public void setJadwalManasik(JadwalManasik jadwalManasik) {
        this.jadwalManasik = jadwalManasik;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }

    public StatusKawin getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawin statusKawin) {
        this.statusKawin = statusKawin;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Pendidikan getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(Pendidikan pendidikan) {
        this.pendidikan = pendidikan;
    }

    public Pekerjaan getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(Pekerjaan pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public Cicilan getCicilan() {
        return cicilan;
    }

    public void setCicilan(Cicilan cicilan) {
        this.cicilan = cicilan;
    }

    public DownPayment getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(DownPayment downPayment) {
        this.downPayment = downPayment;
    }

    public Talangan getTalangan() {
        return talangan;
    }

    public void setTalangan(Talangan talangan) {
        this.talangan = talangan;
    }

    public Ukuran getUkuran() {
        return ukuran;
    }

    public void setUkuran(Ukuran ukuran) {
        this.ukuran = ukuran;
    }

    public Hubungan getHubungan() {
        return hubungan;
    }

    public void setHubungan(Hubungan hubungan) {
        this.hubungan = hubungan;
    }

    public String getNoVisa() {
        return noVisa;
    }

    public void setNoVisa(String noVisa) {
        this.noVisa = noVisa;
    }

    public Date getTglTerbitVisa() {
        return tglTerbitVisa;
    }

    public void setTglTerbitVisa(Date tglTerbitVisa) {
        this.tglTerbitVisa = tglTerbitVisa;
    }

    public Integer getDurasiVisa() {
        return durasiVisa;
    }

    public void setDurasiVisa(Integer durasiVisa) {
        this.durasiVisa = durasiVisa;
    }

    public String getNoPasspor() {
        return noPasspor;
    }

    public void setNoPasspor(String noPasspor) {
        this.noPasspor = noPasspor;
    }

    public Date getTglTerbitPasspor() {
        return tglTerbitPasspor;
    }

    public void setTglTerbitPasspor(Date tglTerbitPasspor) {
        this.tglTerbitPasspor = tglTerbitPasspor;
    }

    public Date getTglHabisPasspor() {
        return tglHabisPasspor;
    }

    public void setTglHabisPasspor(Date tglHabisPasspor) {
        this.tglHabisPasspor = tglHabisPasspor;
    }

    public String getKtrTerbitPasspor() {
        return ktrTerbitPasspor;
    }

    public void setKtrTerbitPasspor(String ktrTerbitPasspor) {
        this.ktrTerbitPasspor = ktrTerbitPasspor;
    }

    public StatusMahram getStatusMahram() {
        return statusMahram;
    }

    public void setStatusMahram(StatusMahram statusMahram) {
        this.statusMahram = statusMahram;
    }

    public String getNamaMahram() {
        return namaMahram;
    }

    public void setNamaMahram(String namaMahram) {
        this.namaMahram = namaMahram;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public StatusAktif getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(StatusAktif statusAktif) {
        this.statusAktif = statusAktif;
    }

    public JenisBayar getJenisBayar() {
        return jenisBayar;
    }

    public void setJenisBayar(JenisBayar jenisBayar) {
        this.jenisBayar = jenisBayar;
    }

    public Va getVa() {
        return va;
    }

    public void setVa(Va va) {
        this.va = va;
    }

    public JamaahApproval getJamaahApproval() {
        return jamaahApproval;
    }

    public void setJamaahApproval(JamaahApproval jamaahApproval) {
        this.jamaahApproval = jamaahApproval;
    }

    public StatusPesawat getStatusPesawat() {
        return statusPesawat;
    }

    public void setStatusPesawat(StatusPesawat statusPesawat) {
        this.statusPesawat = statusPesawat;
    }

    public List<JamaahPenyakit> getJamaahPenyakits() {
        return jamaahPenyakits;
    }

    public void setJamaahPenyakits(List<JamaahPenyakit> jamaahPenyakits) {
        this.jamaahPenyakits = jamaahPenyakits;
    }

    public List<Dokumen> getDokumens() {
        return dokumens;
    }

    public void setDokumens(List<Dokumen> dokumens) {
        this.dokumens = dokumens;
    }

    public Instansi getInstansi() {
        return instansi;
    }

    public void setInstansi(Instansi instansi) {
        this.instansi = instansi;
    }

    @Override
    public String toString() {
        return "Jamaah{" +
                "idJamaah='" + idJamaah + '\'' +
                ", idCard='" + idCard + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", namaAyah='" + namaAyah + '\'' +
                ", nik='" + nik + '\'' +
                ", kk='" + kk + '\'' +
                ", nip='" + nip + '\'' +
                ", tempatLahir='" + tempatLahir + '\'' +
                ", tglLahir=" + tglLahir +
                ", alamat='" + alamat + '\'' +
                ", rtrw='" + rtrw + '\'' +
                ", kelurahan=" + kelurahan +
                ", email='" + email + '\'' +
                ", golonganDarah=" + golonganDarah +
                ", kewarganegaraan=" + kewarganegaraan +
                ", terakhirUmroh=" + terakhirUmroh +
                ", noHp='" + noHp + '\'' +
                ", namaDarurat='" + namaDarurat + '\'' +
                ", noHpDarurat='" + noHpDarurat + '\'' +
                ", alamatDarurat='" + alamatDarurat + '\'' +
                ", tglDaftar=" + tglDaftar +
                ", agen=" + agen +
                ", jadwalManasik=" + jadwalManasik +
                ", paket=" + paket +
                ", statusKawin=" + statusKawin +
                ", jenisKelamin=" + jenisKelamin +
                ", user=" + user +
                ", provinsi=" + provinsi +
                ", kotaKabupaten=" + kotaKabupaten +
                ", kecamatan=" + kecamatan +
                ", pendidikan=" + pendidikan +
                ", pekerjaan=" + pekerjaan +
                ", noRek='" + noRek + '\'' +
                ", cicilan=" + cicilan +
                ", downPayment=" + downPayment +
                ", talangan=" + talangan +
                ", ukuran=" + ukuran +
                ", hubungan=" + hubungan +
                ", noVisa='" + noVisa + '\'' +
                ", tglTerbitVisa=" + tglTerbitVisa +
                ", durasiVisa=" + durasiVisa +
                ", noPasspor='" + noPasspor + '\'' +
                ", tglTerbitPasspor=" + tglTerbitPasspor +
                ", tglHabisPasspor=" + tglHabisPasspor +
                ", ktrTerbitPasspor='" + ktrTerbitPasspor + '\'' +
                ", statusMahram=" + statusMahram +
                ", namaMahram='" + namaMahram + '\'' +
                ", bank=" + bank +
                ", statusAktif=" + statusAktif +
                ", jenisBayar=" + jenisBayar +
                ", va=" + va +
                ", jamaahApproval=" + jamaahApproval +
                ", statusPesawat=" + statusPesawat +
                ", jamaahPenyakits=" + jamaahPenyakits +
                ", dokumens=" + dokumens +
                ", instansi=" + instansi +
                '}';
    }
}
