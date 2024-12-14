package org.example.restspringboot.restspringBoot.rest_example.model;

public class ARTICLE {

    private int ARTICLE;
    private String NAME;

    public ARTICLE(){
    }

    public ARTICLE(int ARTICLE){
        this.ARTICLE = ARTICLE;
    }

    public ARTICLE(int ARTICLE, String NAME) {
        this.ARTICLE = ARTICLE;
        this.NAME = NAME;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getARTICLE() {
        return ARTICLE;
    }

    public void setARTICLE(int ARTICLE) {
        this.ARTICLE = ARTICLE;
    }
}
