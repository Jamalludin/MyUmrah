package com.uninet.myumrah.model.model_register;

public class RegisterModel {

    public String hasil;

    public RegisterModel(String hasil) {
        this.hasil = hasil;
    }

    public String getHasil() {
        return hasil;
    }

    public int isRegister() {

        if (getHasil().equals("0010"))
            return 1;
        else
            return 0;
    }
}
