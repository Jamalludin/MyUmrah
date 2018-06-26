package com.uninet.myumrah.view;

public interface LoginView {
    void onValidasiLoginSucces(String message);
    void onValidasiLoginError(String message);
    void onLoginSuccess(String message);
    void onLoginError(String message);
}
