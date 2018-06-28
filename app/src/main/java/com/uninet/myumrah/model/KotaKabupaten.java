package com.uninet.myumrah.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KotaKabupaten {

    private String idKabupaten;
    private String namaKabupaten;
    private Provinsi provinsi;

    public KotaKabupaten() {
    }

    public KotaKabupaten(String idKabupaten) {
        this.idKabupaten = idKabupaten;
    }
}
