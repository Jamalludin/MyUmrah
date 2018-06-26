package com.uninet.myumrah.model.model_login;

import android.text.TextUtils;

public class ValidasiLoginModel {
    public String namaUser;
    public String password;

    public ValidasiLoginModel(String namaUser, String password) {
        this.namaUser = namaUser;
        this.password = password;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getPassword() {
        return password;
    }

    public int isValidate() {
        if (TextUtils.isEmpty(getNamaUser()))
            return 0;
        else if (TextUtils.isEmpty(getPassword()))
            return 0;
        else
            return 1;
    }
}
