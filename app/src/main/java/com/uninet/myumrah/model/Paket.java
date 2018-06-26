package com.uninet.myumrah.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Paket implements Serializable{

    private String idPaket;
    private String namaPaket;
    private BigDecimal hargaPaket;
    private Integer kuotaPaket;
    private Integer hariPaket;
    private BigDecimal hargaDasar;
    private String destinasi;
    private StatusAktif statusAktif;
    private String gbrPaketMob;
    private String gbrPaketWeb;
    private java.util.Date tglBerangkat;
    private Hotel hotelMekkah;
    private Hotel hotelMadinah;
    private StatusPesawat statusPesawat;
    private List<Agen> agens;

    public Paket(String idPaket) {
        this.idPaket = idPaket;
    }

    public String getIdPaket() {
        return idPaket;
    }

    public void setIdPaket(String idPaket) {
        this.idPaket = idPaket;
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    public BigDecimal getHargaPaket() {
        return hargaPaket;
    }

    public void setHargaPaket(BigDecimal hargaPaket) {
        this.hargaPaket = hargaPaket;
    }

    public Integer getKuotaPaket() {
        return kuotaPaket;
    }

    public void setKuotaPaket(Integer kuotaPaket) {
        this.kuotaPaket = kuotaPaket;
    }

    public Integer getHariPaket() {
        return hariPaket;
    }

    public void setHariPaket(Integer hariPaket) {
        this.hariPaket = hariPaket;
    }

    public BigDecimal getHargaDasar() {
        return hargaDasar;
    }

    public void setHargaDasar(BigDecimal hargaDasar) {
        this.hargaDasar = hargaDasar;
    }

    public String getDestinasi() {
        return destinasi;
    }

    public void setDestinasi(String destinasi) {
        this.destinasi = destinasi;
    }

    public StatusAktif getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(StatusAktif statusAktif) {
        this.statusAktif = statusAktif;
    }

    public String getGbrPaketMob() {
        return gbrPaketMob;
    }

    public void setGbrPaketMob(String gbrPaketMob) {
        this.gbrPaketMob = gbrPaketMob;
    }

    public String getGbrPaketWeb() {
        return gbrPaketWeb;
    }

    public void setGbrPaketWeb(String gbrPaketWeb) {
        this.gbrPaketWeb = gbrPaketWeb;
    }

    public Date getTglBerangkat() {
        return tglBerangkat;
    }

    public void setTglBerangkat(Date tglBerangkat) {
        this.tglBerangkat = tglBerangkat;
    }

    public Hotel getHotelMekkah() {
        return hotelMekkah;
    }

    public void setHotelMekkah(Hotel hotelMekkah) {
        this.hotelMekkah = hotelMekkah;
    }

    public Hotel getHotelMadinah() {
        return hotelMadinah;
    }

    public void setHotelMadinah(Hotel hotelMadinah) {
        this.hotelMadinah = hotelMadinah;
    }

    public StatusPesawat getStatusPesawat() {
        return statusPesawat;
    }

    public void setStatusPesawat(StatusPesawat statusPesawat) {
        this.statusPesawat = statusPesawat;
    }

    public List<Agen> getAgens() {
        return agens;
    }

    public void setAgens(List<Agen> agens) {
        this.agens = agens;
    }

    @Override
    public String toString() {
        return "Paket{" +
                "idPaket='" + idPaket + '\'' +
                ", namaPaket='" + namaPaket + '\'' +
                ", hargaPaket=" + hargaPaket +
                ", kuotaPaket=" + kuotaPaket +
                ", hariPaket=" + hariPaket +
                ", hargaDasar=" + hargaDasar +
                ", destinasi='" + destinasi + '\'' +
                ", statusAktif=" + statusAktif +
                ", gbrPaketMob='" + gbrPaketMob + '\'' +
                ", gbrPaketWeb='" + gbrPaketWeb + '\'' +
                ", tglBerangkat=" + tglBerangkat +
                ", hotelMekkah=" + hotelMekkah +
                ", hotelMadinah=" + hotelMadinah +
                ", statusPesawat=" + statusPesawat +
                ", agens=" + agens +
                '}';
    }
}
