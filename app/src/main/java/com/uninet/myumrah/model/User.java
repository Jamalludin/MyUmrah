package com.uninet.myumrah.model;

import java.io.Serializable;
import java.util.Date;

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

    public User(String namaUser) {
        this.namaUser = namaUser;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public Date getTglRegistrasi() {
        return tglRegistrasi;
    }

    public void setTglRegistrasi(Date tglRegistrasi) {
        this.tglRegistrasi = tglRegistrasi;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public StatusAktif getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(StatusAktif statusAktif) {
        this.statusAktif = statusAktif;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "User{" +
                "totalCount=" + totalCount +
                ", rowNumber=" + rowNumber +
                ", namaUser='" + namaUser + '\'' +
                ", password='" + password + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", email='" + email + '\'' +
                ", noHp='" + noHp + '\'' +
                ", tglRegistrasi=" + tglRegistrasi +
                ", role=" + role +
                ", statusAktif=" + statusAktif +
                ", token='" + token + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
