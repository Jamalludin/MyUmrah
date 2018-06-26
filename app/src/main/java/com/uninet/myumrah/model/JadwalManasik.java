package com.uninet.myumrah.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class JadwalManasik implements Serializable{

    private String idManasik;
    private Date tglManasik;
    private Time jamManasik;
    private String tempatManasik;

    public String getIdManasik() {
        return idManasik;
    }

    public void setIdManasik(String idManasik) {
        this.idManasik = idManasik;
    }

    public Date getTglManasik() {
        return tglManasik;
    }

    public void setTglManasik(Date tglManasik) {
        this.tglManasik = tglManasik;
    }

    public Time getJamManasik() {
        return jamManasik;
    }

    public void setJamManasik(Time jamManasik) {
        this.jamManasik = jamManasik;
    }

    public String getTempatManasik() {
        return tempatManasik;
    }

    public void setTempatManasik(String tempatManasik) {
        this.tempatManasik = tempatManasik;
    }

    @Override
    public String toString() {
        return "JadwalManasik{" +
                "idManasik='" + idManasik + '\'' +
                ", tglManasik=" + tglManasik +
                ", jamManasik=" + jamManasik +
                ", tempatManasik='" + tempatManasik + '\'' +
                '}';
    }
}
