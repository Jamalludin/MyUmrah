package com.uninet.myumrah.model;

import java.io.Serializable;

public class Approval implements Serializable{

    private Integer idApproval;
    private String namaApproval;

    public Integer getIdApproval() {
        return idApproval;
    }

    public void setIdApproval(Integer idApproval) {
        this.idApproval = idApproval;
    }

    public String getNamaApproval() {
        return namaApproval;
    }

    public void setNamaApproval(String namaApproval) {
        this.namaApproval = namaApproval;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "idApproval=" + idApproval +
                ", namaApproval='" + namaApproval + '\'' +
                '}';
    }
}
