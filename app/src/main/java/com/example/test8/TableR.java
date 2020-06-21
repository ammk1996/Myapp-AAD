package com.example.test8;

public class TableR {
    private String CName;
    private String CN;
    private String ph;
    private String DOR;

    public TableR(String CName, String CN, String ph, String DOR) {
        this.CName = CName;
        this.CN = CN;
        this.ph = ph;
        this.DOR = DOR;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCN() {
        return CN;
    }

    public void setCN(String CN) {
        this.CN = CN;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getDOR() {
        return DOR;
    }

    public void setDOR(String DOR) {
        this.DOR = DOR;
    }

    @Override
    public String toString() {
        return "TableR{" +
                "CName='" + CName + '\'' +
                ", CN='" + CN + '\'' +
                ", ph='" + ph + '\'' +
                ", DOR='" + DOR + '\'' +
                '}';
    }
}
