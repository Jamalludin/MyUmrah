package com.uninet.myumrah.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Penyakit implements Serializable{

    private Integer idPenyakit;
    private String namaPenyakit;
    private Integer idStatus;

    public Penyakit() {
    }
}
