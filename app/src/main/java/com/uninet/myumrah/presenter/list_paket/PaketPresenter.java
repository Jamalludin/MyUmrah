package com.uninet.myumrah.presenter.list_paket;

import android.content.Context;

import com.uninet.myumrah.interactor.PaketInteractor;
import com.uninet.myumrah.model.model_paket.ModelPaket;
import com.uninet.myumrah.view.IPaketPresenter;
import com.uninet.myumrah.view.ListPaketView;

public class PaketPresenter implements IPaketPresenter {

    private ListPaketView listPaketView;
    private PaketInteractor paketInteractor;

    public PaketPresenter(ListPaketView listPaketView, Context context) {
        this.listPaketView = listPaketView;
        paketInteractor = new PaketInteractor(context);

    }

    public void setPaket(){
        paketInteractor.PaketRequest(new PaketInteractor.PaketList() {
            @Override
            public void paket(String pakes) {
                listPaketView.paketList(pakes);
            }
        });
    }

    @Override
    public void onValidasi(String lama, String tahun, String bulan, String minggu, String bayar, String intansi, String bank) {
        ModelPaket paket = new ModelPaket(lama,tahun,bulan,minggu,bayar,intansi,bank);
        int paketCode = paket.isValidasi();

        if (paketCode == 0)
            listPaketView.onValidasiError("Mohon Pilih Lama Perjalanan");
        else if (paketCode == 1)
            listPaketView.onValidasiError("Mohon Pilih Tahun Berangkat");
        else if (paketCode == 2)
            listPaketView.onValidasiError("Mohon Pilih Bulan Berangkat");
        else if (paketCode == 3)
            listPaketView.onValidasiError("Mohon Pilih Minggu Berangkat");
        else if (paketCode == 4)
            listPaketView.onValidasiError("Mohon Pilih Cara Bayar");
        else
            listPaketView.onValidasiSucces("");
    }
}
