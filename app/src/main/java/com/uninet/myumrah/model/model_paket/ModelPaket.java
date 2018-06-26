package com.uninet.myumrah.model.model_paket;

public class ModelPaket {

    public String lama;
    public String tahun;
    public String bulan;
    public String minggu;
    public String bayar;
    public String instansi;
    public String bank;

    public ModelPaket(String lama, String tahun, String bulan, String minggu, String bayar, String instansi, String bank) {
        this.lama = lama;
        this.tahun = tahun;
        this.bulan = bulan;
        this.minggu = minggu;
        this.bayar = bayar;
        this.instansi = instansi;
        this.bank = bank;
    }

    public String getLama() {
        return lama;
    }

    public String getTahun() {
        return tahun;
    }

    public String getBulan() {
        return bulan;
    }

    public String getMinggu() {
        return minggu;
    }

    public String getBayar() {
        return bayar;
    }

    public String getInstansi() {
        return instansi;
    }

    public String getBank() {
        return bank;
    }

    public int isValidasi(){
        if (getLama().equalsIgnoreCase("--Pilih--"))
            return 0;
        else if (getTahun().equalsIgnoreCase("--Pilih--"))
            return 1;
        else if (getBulan().equalsIgnoreCase("--Pilih--"))
            return 2;
        else if (getMinggu().equalsIgnoreCase("--Pilih--"))
            return 3;
        else if (getBayar().equalsIgnoreCase("--Pilih--"))
            return 4;
        else
            return 5;
    }
}
