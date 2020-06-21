package com.example.test8;

public class Table {
    private String Name;
    private Integer CA;
    private Long ph;
    private String DOR;

    public Table(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCA() {
        return CA;
    }

    public void setCA(Integer CA) {
        this.CA = CA;
    }

    public Long getPh() {
        return ph;
    }

    public void setPh(Long ph) {
        this.ph = ph;
    }

    public String getDOR() {
        return DOR;
    }

    public void setDOR(String DOR) {
        this.DOR = DOR;
    }
}
