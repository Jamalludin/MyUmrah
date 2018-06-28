package com.uninet.myumrah.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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

    public JamaahApproval() {
    }
}
