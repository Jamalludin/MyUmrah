package com.uninet.myumrah.model;

import android.text.TextUtils;
import android.util.Patterns;

public class DataDiriModel {

    public String namaLengkap;
    public String namaAyah;
    public String tempatLahir;
    public String noKK;
    public String nik;
    public String noHp;
    public String email;
    public String tglLahir;
    public String jenisKelamin;
    public String statusKawin;
    public String kewargaNegaraan;
    public String golonganDarah;

    public DataDiriModel(String namaLengkap, String namaAyah, String tempatLahir, String noKK,
                         String nik, String noHp, String email, String tglLahir, String jenisKelamin,
                         String statusKawin, String kewargaNegaraan, String golonganDarah) {
        this.namaLengkap = namaLengkap;
        this.namaAyah = namaAyah;
        this.tempatLahir = tempatLahir;
        this.noKK = noKK;
        this.nik = nik;
        this.noHp = noHp;
        this.email = email;
        this.tglLahir = tglLahir;
        this.jenisKelamin = jenisKelamin;
        this.statusKawin = statusKawin;
        this.kewargaNegaraan = kewargaNegaraan;
        this.golonganDarah = golonganDarah;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public String getNoKK() {
        return noKK;
    }

    public String getNik() {
        return nik;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getEmail() {
        return email;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getStatusKawin() {
        return statusKawin;
    }

    public String getKewargaNegaraan() {
        return kewargaNegaraan;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public int isValidasi(){
        if (TextUtils.isEmpty(getNamaLengkap()))
            return 0;
        else if (TextUtils.isEmpty(getNamaAyah()))
            return 1;
        else if (TextUtils.isEmpty(getTempatLahir()))
            return 2;
        else if (TextUtils.isEmpty(getNoKK()))
            return 3;
        else if (getNoKK().length() < 16)
            return 4;
        else if (TextUtils.isEmpty(getNik()))
            return 5;
        else if (getNik().length() < 16)
            return 6;
        else if (TextUtils.isEmpty(getNoHp()))
            return 7;
        else if (getNoHp().length() < 11)
            return 8;
        else if (TextUtils.isEmpty(getEmail()))
            return 9;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 10;
        else if (TextUtils.isEmpty(getTglLahir()))
            return 11;
        else
            return 12;
    }
}
