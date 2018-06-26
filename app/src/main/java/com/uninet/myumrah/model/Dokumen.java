package com.uninet.myumrah.model;

import java.io.Serializable;
import java.util.Date;

public class Dokumen implements Serializable{

    private Integer idDokumen;
    private String namaDokumen;
    private Date tglSerah;
    private Serah serah;
    private String gbrDokumen;
    private Object media;
    private Jamaah jamaah;

    public Integer getIdDokumen() {
        return idDokumen;
    }

    public void setIdDokumen(Integer idDokumen) {
        this.idDokumen = idDokumen;
    }

    public String getNamaDokumen() {
        return namaDokumen;
    }

    public void setNamaDokumen(String namaDokumen) {
        this.namaDokumen = namaDokumen;
    }

    public Date getTglSerah() {
        return tglSerah;
    }

    public void setTglSerah(Date tglSerah) {
        this.tglSerah = tglSerah;
    }

    public Serah getSerah() {
        return serah;
    }

    public void setSerah(Serah serah) {
        this.serah = serah;
    }

    public String getGbrDokumen() {
        return gbrDokumen;
    }

    public void setGbrDokumen(String gbrDokumen) {
        this.gbrDokumen = gbrDokumen;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Jamaah getJamaah() {
        return jamaah;
    }

    public void setJamaah(Jamaah jamaah) {
        this.jamaah = jamaah;
    }

    @Override
    public String toString() {
        return "Dokumen{" +
                "idDokumen=" + idDokumen +
                ", namaDokumen='" + namaDokumen + '\'' +
                ", tglSerah=" + tglSerah +
                ", serah=" + serah +
                ", gbrDokumen='" + gbrDokumen + '\'' +
                ", media=" + media +
                ", jamaah=" + jamaah +
                '}';
    }
}
