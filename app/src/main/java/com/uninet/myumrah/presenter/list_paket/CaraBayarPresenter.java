package com.uninet.myumrah.presenter.list_paket;

import android.content.Context;

import com.uninet.myumrah.interactor.CaraBayarInteractor;
import com.uninet.myumrah.view.ListPaketView;

public class CaraBayarPresenter {
    private ListPaketView listPaketView;
    private CaraBayarInteractor caraBayarInteractor;

    public CaraBayarPresenter(ListPaketView listPaketView, Context context) {
        this.listPaketView = listPaketView;
        caraBayarInteractor = new CaraBayarInteractor(context);
    }

    public void setCaraBayar(){
        caraBayarInteractor.CaraBayarRequest(new CaraBayarInteractor.ListBayar() {
            @Override
            public void bayar(String bayar) {
                listPaketView.caraBayar(bayar);
            }
        });
    }
}
