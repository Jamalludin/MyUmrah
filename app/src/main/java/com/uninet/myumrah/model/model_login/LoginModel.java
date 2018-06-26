package com.uninet.myumrah.model.model_login;

public class LoginModel {
    public String hasil;

    public LoginModel(String hasil) {
        this.hasil = hasil;
    }

    public String getHasil() {
        return hasil;
    }

    public int isLogin() {
        if (getHasil().equals("success"))
            return 1;
        else
            return 0;
    }
}
