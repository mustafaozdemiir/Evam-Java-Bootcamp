package com.week2.models;

import java.util.Date;
// Değişkenlere sınıf dışından erişilmemesi için private olarak tanımlandı. Getter ve setter metodları oluşturuldu.
public class Bill {
    private int id;
    private double amount;
    private Date processDate;
    private int billType ;
    private String memberCode;

    public Bill() {

    }

    public Bill(int id, double amount, Date processDate, int billType, String memberCode) {
        this.id = id;
        this.amount = amount;
        this.processDate = processDate;
        this.billType = billType;
        this.memberCode = memberCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }
}
