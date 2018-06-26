package com.uninet.myumrah.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class DownPayment implements Serializable{

    private Integer idDp;
    private BigDecimal nominalDp;
    private String nominalDpFormated;
    private Bank bank;
    private Integer idStatusDp;
    private List<Cicilan> cicilans;

    public DownPayment(Integer idDp) {
        this.idDp = idDp;
    }

    public Integer getIdDp() {
        return idDp;
    }

    public void setIdDp(Integer idDp) {
        this.idDp = idDp;
    }

    public BigDecimal getNominalDp() {
        return nominalDp;
    }

    public void setNominalDp(BigDecimal nominalDp) {
        this.nominalDp = nominalDp;
    }

    public String getNominalDpFormated() {
        return nominalDpFormated;
    }

    public void setNominalDpFormated(String nominalDpFormated) {
        this.nominalDpFormated = nominalDpFormated;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getIdStatusDp() {
        return idStatusDp;
    }

    public void setIdStatusDp(Integer idStatusDp) {
        this.idStatusDp = idStatusDp;
    }

    public List<Cicilan> getCicilans() {
        return cicilans;
    }

    public void setCicilans(List<Cicilan> cicilans) {
        this.cicilans = cicilans;
    }

    @Override
    public String toString() {
        return "DownPayment{" +
                "idDp=" + idDp +
                ", nominalDp=" + nominalDp +
                ", nominalDpFormated='" + nominalDpFormated + '\'' +
                ", bank=" + bank +
                ", idStatusDp=" + idStatusDp +
                ", cicilans=" + cicilans +
                '}';
    }
}
