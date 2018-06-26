package com.uninet.myumrah.presenter;

import android.content.Context;

import com.uninet.myumrah.interactor.CicilanInteractor;
import com.uninet.myumrah.interactor.DownPaymentInteractor;
import com.uninet.myumrah.view.CicilanPaketView;

public class DownPaymentPresenter {
    private CicilanPaketView cicilanPaketView;
    private DownPaymentInteractor downPaymentInteractor;
    private CicilanInteractor cicilanInteractor;

    public DownPaymentPresenter(CicilanPaketView cicilanPaketView, Context context) {
        this.cicilanPaketView = cicilanPaketView;
        downPaymentInteractor = new DownPaymentInteractor(context);
        cicilanInteractor = new CicilanInteractor(context);
    }

    public void setDownPayment(){
        downPaymentInteractor.DownPayment(new DownPaymentInteractor.DownPaymentList() {
            @Override
            public void listDP(String listDP) {
                cicilanPaketView.listDownPayment(listDP);
            }
        });
    }

    public void setCicilan(){
        cicilanInteractor.Cicilan(new CicilanInteractor.CicilanList() {
            @Override
            public void CicilanList(String cicilanList) {
                cicilanPaketView.listCicilan(cicilanList);
            }
        });
    }

    public void setTalangan(){
        cicilanInteractor.talangan(new CicilanInteractor.TalanganList() {
            @Override
            public void TalanganList(String talangan) {
                cicilanPaketView.listTalangan(talangan);
            }
        });
    }
}
