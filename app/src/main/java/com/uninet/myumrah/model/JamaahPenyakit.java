package com.uninet.myumrah.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JamaahPenyakit implements Serializable {

    private Integer lamaPenyakit;
    private Integer tahunPenyakitIntType;
    private Penyakit penyakit;
    private Jamaah jamaah;
    private StatusPenyakit statusPenyakit;

}
