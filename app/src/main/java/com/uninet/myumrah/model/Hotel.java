package com.uninet.myumrah.model;

import java.io.Serializable;

public class Hotel implements Serializable{

    private Integer idHotel;
    private String namaHotel;
    private String alamatHotel;
    private String rateBintang;

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getAlamatHotel() {
        return alamatHotel;
    }

    public void setAlamatHotel(String alamatHotel) {
        this.alamatHotel = alamatHotel;
    }

    public String getRateBintang() {
        return rateBintang;
    }

    public void setRateBintang(String rateBintang) {
        this.rateBintang = rateBintang;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "idHotel=" + idHotel +
                ", namaHotel='" + namaHotel + '\'' +
                ", alamatHotel='" + alamatHotel + '\'' +
                ", rateBintang='" + rateBintang + '\'' +
                '}';
    }
}
