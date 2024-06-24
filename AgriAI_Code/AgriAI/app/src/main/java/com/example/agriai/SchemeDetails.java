package com.example.agriai;

public class SchemeDetails {

    private int sid;
    private String schemename,schemetype,eligibility,duration;

    public SchemeDetails(int sid, String schemename, String schemetype, String eligibility, String duration) {
        this.sid = sid;
        this.schemename = schemename;
        this.schemetype = schemetype;
        this.eligibility = eligibility;
        this.duration = duration;
    }

    public SchemeDetails(String schemename, String schemetype, String eligibility, String duration) {
        this.schemename = schemename;
        this.schemetype = schemetype;
        this.eligibility = eligibility;
        this.duration = duration;
    }

    public SchemeDetails(CreateSchemeAct createSchemeAct) {

    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSchemename(String schemename) {
        this.schemename = schemename;
    }

    public void setSchemetype(String schemetype) {
        this.schemetype = schemetype;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getSid() {
        return sid;
    }

    public String getSchemename() {
        return schemename;
    }

    public String getSchemetype() {
        return schemetype;
    }

    public String getEligibility() {
        return eligibility;
    }

    public String getDuration() {
        return duration;
    }
}
