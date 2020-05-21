package com.adel.stcpay.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Senates {
    @SerializedName("objects")
    private List<Senate> list;

    public Senates(List<Senate> list) {
        this.list = list;
    }

    public List<Senate> getList() {
        return list;
    }

    public void setList(List<Senate> list) {
        this.list = list;
    }
}
