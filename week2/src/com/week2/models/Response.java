package com.week2.models;

// Değişkenlere sınıf dışından erişilmemesi için private olarak tanımlandı. Getter ve setter metodları oluşturuldu.
public class Response {
    private String code;
    private String date;

    public Response() {
    }

    public Response(String code, String date) {
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
