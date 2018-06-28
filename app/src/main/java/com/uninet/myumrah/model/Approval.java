package com.uninet.myumrah.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Approval implements Serializable{

    private Integer idApproval;
    private String namaApproval;

    public Approval() {
    }

    public Approval(Integer idApproval) {
        this.idApproval = idApproval;
    }
}
