package org.example.restspringboot.restspringBoot.rest_example.model;

public class SALAS10000 {

    private String NAME;
    private Integer MANY;

    public SALAS10000(){
    }

    public SALAS10000(String NAME){
        this.NAME = NAME;
    }
    public SALAS10000(String NAME, Integer MANY) {
        this.NAME = NAME;
        this.MANY = MANY;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getMANY() {
        return MANY;
    }

    public void setMANY(Integer MANY) {
        this.MANY = MANY;
    }
}
