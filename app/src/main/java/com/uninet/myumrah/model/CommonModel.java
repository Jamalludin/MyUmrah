package com.uninet.myumrah.model;

public class CommonModel<T> {

    String status;
    T data;
    String roles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "CommonModel{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", roles='" + roles + '\'' +
                '}';
    }
}
