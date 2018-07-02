package com.uninet.myumrah.presenter;

import android.content.Context;

import com.uninet.myumrah.interactor.JamaahInteractor;
import com.uninet.myumrah.view.CekStatusView;

public class CekStatusPresenter {
    private CekStatusView approvalView;
    private JamaahInteractor jamaahInteractor;

    public CekStatusPresenter(CekStatusView approvalView, Context context) {
        this.approvalView = approvalView;
        jamaahInteractor = new JamaahInteractor(context);
    }

    public void cekStatus(){
        jamaahInteractor.findByNamaUser(new JamaahInteractor.FindByNamaUser() {
            @Override
            public void findByNamaUser(String namaUser) {
                approvalView.statusView(namaUser);
            }
        });
    }
}
