package com.uninet.myumrah.model;

import java.io.Serializable;
import java.sql.Date;

public class JamaahApproval implements Serializable {

    private Jamaah jamaah;
    private Approval approval;
    private StatusApproval statusApproval;
    private Date tglApprovalKoperasi;
    private Date tglApprovalBank;
    private Date tglApprovalMyumroh;
    private String assesmentKoperasi;
    private String assesmentBank;
    private String assesmentMyumroh;

    public Jamaah getJamaah() {
        return jamaah;
    }

    public void setJamaah(Jamaah jamaah) {
        this.jamaah = jamaah;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    public StatusApproval getStatusApproval() {
        return statusApproval;
    }

    public void setStatusApproval(StatusApproval statusApproval) {
        this.statusApproval = statusApproval;
    }

    public Date getTglApprovalKoperasi() {
        return tglApprovalKoperasi;
    }

    public void setTglApprovalKoperasi(Date tglApprovalKoperasi) {
        this.tglApprovalKoperasi = tglApprovalKoperasi;
    }

    public Date getTglApprovalBank() {
        return tglApprovalBank;
    }

    public void setTglApprovalBank(Date tglApprovalBank) {
        this.tglApprovalBank = tglApprovalBank;
    }

    public Date getTglApprovalMyumroh() {
        return tglApprovalMyumroh;
    }

    public void setTglApprovalMyumroh(Date tglApprovalMyumroh) {
        this.tglApprovalMyumroh = tglApprovalMyumroh;
    }

    public String getAssesmentKoperasi() {
        return assesmentKoperasi;
    }

    public void setAssesmentKoperasi(String assesmentKoperasi) {
        this.assesmentKoperasi = assesmentKoperasi;
    }

    public String getAssesmentBank() {
        return assesmentBank;
    }

    public void setAssesmentBank(String assesmentBank) {
        this.assesmentBank = assesmentBank;
    }

    public String getAssesmentMyumroh() {
        return assesmentMyumroh;
    }

    public void setAssesmentMyumroh(String assesmentMyumroh) {
        this.assesmentMyumroh = assesmentMyumroh;
    }

    @Override
    public String toString() {
        return "JamaahApproval{" +
                "jamaah=" + jamaah +
                ", approval=" + approval +
                ", statusApproval=" + statusApproval +
                ", tglApprovalKoperasi=" + tglApprovalKoperasi +
                ", tglApprovalBank=" + tglApprovalBank +
                ", tglApprovalMyumroh=" + tglApprovalMyumroh +
                ", assesmentKoperasi='" + assesmentKoperasi + '\'' +
                ", assesmentBank='" + assesmentBank + '\'' +
                ", assesmentMyumroh='" + assesmentMyumroh + '\'' +
                '}';
    }
}
