package com.uninet.myumrah.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StatusApproval implements Serializable {

    private Integer idStatus;
    private String namaStatus;

    public StatusApproval() {
    }

    public StatusApproval(Integer idStatus) {
        this.idStatus = idStatus;
    }
}
