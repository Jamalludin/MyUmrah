package com.uninet.myumrah.presenter.presenter_login;

import com.uninet.myumrah.model.model_login.LoginModel;
import com.uninet.myumrah.model.model_login.ValidasiLoginModel;
import com.uninet.myumrah.view.ILoginPresenter;
import com.uninet.myumrah.view.LoginView;

public class LoginPresenter implements ILoginPresenter {
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }


    @Override
    public void onValidasi(String namaUser, String password) {
        ValidasiLoginModel login = new ValidasiLoginModel(namaUser,password);
        int loginCode = login.isValidate();

        if (loginCode == 0)
            loginView.onValidasiLoginError("Mohon Isi Field");
        else
            loginView.onValidasiLoginSucces("");
    }

    @Override
    public void onLogin(String hasil) {
        LoginModel login = new LoginModel(hasil);
        int loginCode = login.isLogin();

        if (loginCode == 1)
            loginView.onLoginSuccess("Selamat Datang");
        else
            loginView.onLoginError("Invalid Username or Password");

    }
}
