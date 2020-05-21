package com.adel.stcpay.domain;

import com.google.gson.annotations.SerializedName;

public class Senate {

    @SerializedName("person")
    private PersonalDetails personalDetails;
    @SerializedName("role_type_label")
    private String role;
    @SerializedName("extra")
    private Address address;
    @SerializedName("state")
    private String state;
    @SerializedName("party")
    private String party;
    @SerializedName("description")
    private String description;
    @SerializedName("enddate")
    private String enddate;
    @SerializedName("website")
    private String website;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
