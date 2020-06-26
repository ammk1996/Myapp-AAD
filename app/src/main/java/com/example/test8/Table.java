package com.example.test8;

public class Table {
    private String Customer_Name;
    private Integer Customer_Amount;
    private Integer phone;
    private String Date_and_Time;

    public Table(){

    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String name) {
        Customer_Name = name;
    }

    public Integer getCustomer_Amount() {
        return Customer_Amount;
    }

    public void setCustomer_Amount(Integer CA) {
        this.Customer_Amount = CA;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer ph) {
        this.phone = ph;
    }

    public String getDate_and_Time() {
        return Date_and_Time;
    }

    public void setDate_and_Time(String DOR) {
        this.Date_and_Time = DOR;
    }
}
