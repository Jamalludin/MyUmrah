package com.uninet.myumrah.model.model_register;

import android.text.TextUtils;
import android.util.Patterns;

public class ValidasiRegisterModel {
    public String namaLengkap;
    public String namaUser;
    public String email;
    public String noHp;

    public ValidasiRegisterModel(String namaLengkap, String namaUser, String email, String noHp) {
        this.namaLengkap = namaLengkap;
        this.namaUser = namaUser;
        this.email = email;
        this.noHp = noHp;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getEmail() {
        return email;
    }

    public String getNoHp() {
        return noHp;
    }

    public int isValidate() {

        if (TextUtils.isEmpty(getNamaLengkap()))
            return 0;
        else if (TextUtils.isEmpty(getNamaUser()))
            return 0;
        else if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (TextUtils.isEmpty(getNoHp()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getNoHp().length() <= 11)
            return 2;
        else
            return 3;

    }
}
