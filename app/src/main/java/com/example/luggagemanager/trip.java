package com.example.luggagemanager;

public class trip {
    private String AIRLINENAME;
    private String TRIPNAME;
    private String SOURCEADDRESS;
    private String DESTINATIONADDRESS;
    private String DEPARTUREDATE;
    private String ARRIVALDATE;
    private String BAGCOUNT;
    private String MOBILE;
    private Boolean INSURANCE;

    public trip() {
    }

    public String getAIRLINENAME() {
        return AIRLINENAME;
    }

    public void setAIRLINENAME(String AIRLINENAME) {
        this.AIRLINENAME = AIRLINENAME;
    }

    public String getTRIPNAME() {
        return TRIPNAME;
    }

    public void setTRIPNAME(String TRIPNAME) {
        this.TRIPNAME = TRIPNAME;
    }

    public String getSOURCEADDRESS() {
        return SOURCEADDRESS;
    }

    public void setSOURCEADDRESS(String SOURCEADDRESS) {
        this.SOURCEADDRESS = SOURCEADDRESS;
    }

    public String getDESTINATIONADDRESS() {
        return DESTINATIONADDRESS;
    }

    public void setDESTINATIONADDRESS(String DESTINATIONADDRESS) {
        this.DESTINATIONADDRESS = DESTINATIONADDRESS;
    }

    public String getDEPARTUREDATE() {
        return DEPARTUREDATE;
    }

    public void setDEPARTUREDATE(String DEPARTUREDATE) {
        this.DEPARTUREDATE = DEPARTUREDATE;
    }

    public String getARRIVALDATE() {
        return ARRIVALDATE;
    }

    public void setARRIVALDATE(String ARRIVALDATE) {
        this.ARRIVALDATE = ARRIVALDATE;
    }

    public String getBAGCOUNT() {
        return BAGCOUNT;
    }

    public void setBAGCOUNT(String BAGCOUNT) {
        this.BAGCOUNT = BAGCOUNT;
    }

    public Boolean getINSURANCE() {
        return INSURANCE;
    }


    public void setINSURANCE(Boolean INSURANCE) {
        this.INSURANCE = INSURANCE;
    }
    public String getMOBILE() {
        return MOBILE;
    }


    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }
}