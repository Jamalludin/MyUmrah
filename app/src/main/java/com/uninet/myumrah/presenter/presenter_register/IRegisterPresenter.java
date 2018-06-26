package com.uninet.myumrah.presenter.presenter_register;

public interface IRegisterPresenter {

    void onValidasi(String namaLengkap,String namaUser,String email, String noHp);
    void onResgister(String hasil);
}
