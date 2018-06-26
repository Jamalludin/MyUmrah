package com.uninet.myumrah.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cicilan implements Serializable{

    private Integer idCicilan;
    private BigDecimal nominalCicilan;
    private String nominalCicilanFormated;
    private Integer lamaCicilan;
    private Integer idDp;
    private Integer idTalangan;
    private Integer idBank;

    public Cicilan() {
    }

    public Cicilan(Integer idCicilan) {
        this.idCicilan = idCicilan;
    }

    public Integer getIdCicilan() {
        return idCicilan;
    }

    public void setIdCicilan(Integer idCicilan) {
        this.idCicilan = idCicilan;
    }

    public BigDecimal getNominalCicilan() {
        return nominalCicilan;
    }

    public void setNominalCicilan(BigDecimal nominalCicilan) {
        this.nominalCicilan = nominalCicilan;
    }

    public String getNominalCicilanFormated() {
        return nominalCicilanFormated;
    }

    public void setNominalCicilanFormated(String nominalCicilanFormated) {
        this.nominalCicilanFormated = nominalCicilanFormated;
    }

    public Integer getLamaCicilan() {
        return lamaCicilan;
    }

    public void setLamaCicilan(Integer lamaCicilan) {
        this.lamaCicilan = lamaCicilan;
    }

    public Integer getIdDp() {
        return idDp;
    }

    public void setIdDp(Integer idDp) {
        this.idDp = idDp;
    }

    public Integer getIdTalangan() {
        return idTalangan;
    }

    public void setIdTalangan(Integer idTalangan) {
        this.idTalangan = idTalangan;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    @Override
    public String toString() {
        return "Cicilan{" +
                "idCicilan=" + idCicilan +
                ", nominalCicilan=" + nominalCicilan +
                ", nominalCicilanFormated='" + nominalCicilanFormated + '\'' +
                ", lamaCicilan=" + lamaCicilan +
                ", idDp=" + idDp +
                ", idTalangan=" + idTalangan +
                ", idBank=" + idBank +
                '}';
    }
}
