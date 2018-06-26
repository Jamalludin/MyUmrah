package com.uninet.myumrah.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Optional;

public class JamaahPenyakit implements Serializable {

    private Integer lamaPenyakit;
    private Optional tahunPenyakit;
    private Penyakit penyakit;
    private Jamaah jamaah;
    private StatusPenyakit statusPenyakit;

    public Integer getLamaPenyakit() {
        return lamaPenyakit;
    }

    public void setLamaPenyakit(Integer lamaPenyakit) {
        this.lamaPenyakit = lamaPenyakit;
    }

    public Optional getTahunPenyakit() {
        return tahunPenyakit;
    }

    public void setTahunPenyakit(Optional tahunPenyakit) {
        this.tahunPenyakit = tahunPenyakit;
    }

    public Penyakit getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(Penyakit penyakit) {
        this.penyakit = penyakit;
    }

    public Jamaah getJamaah() {
        return jamaah;
    }

    public void setJamaah(Jamaah jamaah) {
        this.jamaah = jamaah;
    }

    public StatusPenyakit getStatusPenyakit() {
        return statusPenyakit;
    }

    public void setStatusPenyakit(StatusPenyakit statusPenyakit) {
        this.statusPenyakit = statusPenyakit;
    }

    @Override
    public String toString() {
        return "JamaahPenyakit{" +
                "lamaPenyakit=" + lamaPenyakit +
                ", tahunPenyakit=" + tahunPenyakit +
                ", penyakit=" + penyakit +
                ", jamaah=" + jamaah +
                ", statusPenyakit=" + statusPenyakit +
                '}';
    }
}
