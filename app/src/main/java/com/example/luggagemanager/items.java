package com.example.luggagemanager;

public class items {
    private String BAGTYPE;
    private String BAGINFO;
    private String ITEMNAME;
    private String ITEMQTY;
    private String ITEMPRICE;

    public items() {
    }

    public String getITEMNAME() {
        return ITEMNAME;
    }

    public void setITEMNAME(String ITEMNAME) {
        this.ITEMNAME = ITEMNAME;
    }

    public String getITEMQTY() {
        return ITEMQTY;
    }

    public void setITEMQTY(String ITEMQTY) {
        this.ITEMQTY = ITEMQTY;
    }

    public String getITEMPRICE() {
        return ITEMPRICE;
    }

    public void setITEMPRICE(String ITEMPRICE) {
        this.ITEMPRICE = ITEMPRICE;
    }
    public String getBAGTYPE() {
        return BAGTYPE;
    }

    public void setBAGTYPE(String BAGTYPE) {
        this.BAGTYPE = BAGTYPE;
    }
    public String getBAGINFO() {
        return BAGINFO;
    }

    public void setBAGINFO(String BAGINFO) {
        this.BAGINFO = BAGINFO;
    }
}
