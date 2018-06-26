package com.uninet.myumrah.presenter.presenter_register;

import com.uninet.myumrah.model.model_register.RegisterModel;
import com.uninet.myumrah.model.model_register.ValidasiRegisterModel;
import com.uninet.myumrah.view.RegisterView;

public class RegisterPresenter implements IRegisterPresenter{
    private RegisterView registerView;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Override
    public void onValidasi(String namaLengkap, String namaUser, String email, String noHp) {
        ValidasiRegisterModel register = new ValidasiRegisterModel(namaLengkap,namaUser,email,noHp);
        int registerCode = register.isValidate();

        if (registerCode == 0)
            registerView.onValidasiError("Field Harus Diisi");
        else if (registerCode == 1)
            registerView.onValidasiError("Isi Email Dengan Benar");
        else if (registerCode == 2)
            registerView.onValidasiError("No Hp Minimal 11 digit Maksimal 14 digit");
        else
            registerView.onValidasiSucces("");

    }

    @Override
    public void onResgister(String hasil) {

        RegisterModel registerModel = new RegisterModel(hasil);
        int code = registerModel.isRegister();

        if (code == 0)
            registerView.onRegisterError("Gagal Melakukan Registrasi");
        else
            registerView.onRegisterSuccess("Berhasil Register");
            registerView.onRegisterSuccess("Silahkan Cek Email Untuk Password Login");

    }

}
