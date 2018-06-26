package com.uninet.myumrah.view;

import com.uninet.myumrah.model.Paket;

import java.util.List;

public interface ListPaketView {
    void lamaHari(String hari);
    void caraBayar(String bayar);
    void instansiList(String instansi);
    void bankList(String bank);
    void paketList(String paketList);
    void onValidasiSucces(String message);
    void onValidasiError(String message);
}
