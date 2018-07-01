package com.uninet.myumrah.presenter;

import android.content.Context;

import com.uninet.myumrah.interactor.BayarInteractor;
import com.uninet.myumrah.view.BayarView;

public class BayarPresenter {

    private BayarView bayarView;
    private BayarInteractor bayarInteractor;

    public BayarPresenter(BayarView bayarView, Context context) {
        this.bayarView = bayarView;
        bayarInteractor = new BayarInteractor(context);
    }

    public void setDetaiTagihan(){
        bayarInteractor.tagihanBayar(new BayarInteractor.Tagihan() {
            @Override
            public void tagihan(String tagihanBayar) {
                bayarView.detailTagihan(tagihanBayar);
            }
        });
    }
}
