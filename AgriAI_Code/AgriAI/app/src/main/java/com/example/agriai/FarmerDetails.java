package com.example.agriai;

public class FarmerDetails {
    public int uid;
    String username, email, district, taluka, mobileno;

    FarmerDetails(){}
    public FarmerDetails(int uid, String username, String email, String district, String taluka, String mobileno) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.district = district;
        this.taluka = taluka;
        this.mobileno = mobileno;
    }

    public FarmerDetails(String username, String email, String district, String taluka, String mobileno) {
        this.username = username;
        this.email = email;
        this.district = district;
        this.taluka = taluka;
        this.mobileno = mobileno;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
