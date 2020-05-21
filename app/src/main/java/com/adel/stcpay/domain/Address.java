package com.adel.stcpay.domain;

import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("address")
    private String address;
    @SerializedName("office")
    private String office;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
