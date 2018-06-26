package com.uninet.myumrah.presenter.list_paket;

import android.content.Context;

import com.uninet.myumrah.interactor.BankInteractor;
import com.uninet.myumrah.interactor.LamaPaketInteractor;
import com.uninet.myumrah.view.ListPaketView;

public class LamaHariPresenter {
    private ListPaketView listPaketView;
    private LamaPaketInteractor lamaPaketInteractor;
    private BankInteractor bankInteractor;

    public LamaHariPresenter(ListPaketView listPaketView, Context context) {
        this.listPaketView = listPaketView;
        lamaPaketInteractor = new LamaPaketInteractor(context);
    }

    public void setLamaHari(){
        lamaPaketInteractor.LamaPaketRequest(new LamaPaketInteractor.LamaHari() {
            @Override
            public void Hasil(String hasil) {
                listPaketView.lamaHari(hasil);
            }
        });
    }
}
