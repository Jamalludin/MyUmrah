package com.uninet.myumrah.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Talangan implements Serializable{

    private Integer idTalangan;
    private BigDecimal nominalTalangan;
    private Bank bank;
    private List<DownPayment> downPayments;

    public Talangan(Integer idTalangan) {
        this.idTalangan = idTalangan;
    }

    public Integer getIdTalangan() {
        return idTalangan;
    }

    public void setIdTalangan(Integer idTalangan) {
        this.idTalangan = idTalangan;
    }

    public BigDecimal getNominalTalangan() {
        return nominalTalangan;
    }

    public void setNominalTalangan(BigDecimal nominalTalangan) {
        this.nominalTalangan = nominalTalangan;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<DownPayment> getDownPayments() {
        return downPayments;
    }

    public void setDownPayments(List<DownPayment> downPayments) {
        this.downPayments = downPayments;
    }

    @Override
    public String toString() {
        return "Talangan{" +
                "idTalangan=" + idTalangan +
                ", nominalTalangan=" + nominalTalangan +
                ", bank=" + bank +
                ", downPayments=" + downPayments +
                '}';
    }
}
