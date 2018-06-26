package com.uninet.myumrah.presenter.list_paket;

import android.content.Context;

import com.uninet.myumrah.interactor.InstansiInteractor;
import com.uninet.myumrah.view.ListPaketView;

public class InstansiPresenter {
    private ListPaketView listPaketView;
    private InstansiInteractor instansiInteractor;

    public InstansiPresenter(ListPaketView listPaketView, Context context) {
        this.listPaketView = listPaketView;
        instansiInteractor = new InstansiInteractor(context);
    }

    public void setInstansi(){
        instansiInteractor.InstansiRequest(new InstansiInteractor.ListInstansi() {
            @Override
            public void instansi(String instansi) {
                listPaketView.instansiList(instansi);
            }
        });
    }
}
