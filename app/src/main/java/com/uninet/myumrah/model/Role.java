package com.uninet.myumrah.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Role implements Serializable{

    private Long idRole;
    private String namaRole;
    private String keterangan;

    public Role() {
    }

    public Role(String namaRole) {
        this.namaRole = namaRole;
    }
}
