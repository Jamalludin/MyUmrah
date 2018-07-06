package com.uninet.myumrah.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class User implements Serializable {

    private Integer totalCount;
    private Integer rowNumber;
    private String namaUser;
    private String password;
    private String namaLengkap;
    private String email;
    private String noHp;
    private Date tglRegistrasi;
    private Role role;
    private StatusAktif statusAktif;
    private String token;
    private String foto;

    public User() {
    }

    public User(String namaUser) {
        this.namaUser = namaUser;
    }

    public User(Role role) {
        this.role = role;
    }
}
