package org.example.restspringboot.restspringBoot.rest_example.model;

public class DRESS {

    private String NAME;
    private String BRAND;

    public DRESS(){
    }

    public DRESS(String NAME){
        this.NAME = NAME;
    }
    public DRESS(String NAME, String BRAND) {
        this.NAME = NAME;
        this.BRAND = BRAND;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }
}
