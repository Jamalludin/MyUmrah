package com.uninet.myumrah.presenter.list_paket;

import android.content.Context;

import com.uninet.myumrah.interactor.BankInteractor;
import com.uninet.myumrah.view.ListPaketView;

public class BankPresenter {
    private ListPaketView listPaketView;
    private BankInteractor bankInteractor;

    public BankPresenter (ListPaketView listPaketView, Context context) {
        this.listPaketView = listPaketView;
        bankInteractor = new BankInteractor(context);
    }

    public void setBank(){
        bankInteractor.BankRequest(new BankInteractor.ListBank() {
            @Override
            public void bank(String bank) {
                listPaketView.bankList(bank);
            }
        });
    }
}
