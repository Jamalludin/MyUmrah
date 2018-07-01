package com.uninet.myumrah.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
    private String dinasPekerjaan;

    public Jamaah() {
    }

    public Jamaah(String idJamaah, String noRek) {
        this.idJamaah = idJamaah;
        this.noRek = noRek;
    }
}
