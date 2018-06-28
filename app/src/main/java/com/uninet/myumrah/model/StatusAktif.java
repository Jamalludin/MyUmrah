package com.uninet.myumrah.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StatusAktif implements Serializable{

    private Integer idStatusAktif;
    private String namaStatusAktif;

    public StatusAktif() {
    }

    public StatusAktif(Integer idStatusAktif) {
        this.idStatusAktif = idStatusAktif;
    }
}
