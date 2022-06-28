package com.week2.services;

import com.week2.LowBalanceException;
import com.week2.models.Response;

import java.util.Date;

//Client interface ten implement edildi.
public class BillServices implements Client {

    public boolean status=true;
    @Override // Client interface in metodları override edildi.
    public  Response payment(int billType, String memberCode,double balance, double amount) throws LowBalanceException{

        if(balance<amount){// Bakiye kontrolü için LowBalanceException sınıfından exception fırlatılıyor.
            throw new LowBalanceException("Bakiye yetersiz");
        }
        else{
            return new Response("0","2022-10-10");// Sorun yok ise Response sınıfından geri dönüş gönderiliyor.
        }
    }

    @Override
    public Response inquire(int billType, String memberCode) {
        if(status){
            return new Response("0","2022-10-10");

        }else {
            return new Response("1","2022-10-10");

        }
    }

    @Override
    public Response inquire(int billType, String memberCode, double amount, Date billDate) {
        if(status){
            return new Response("0","2022-10-10");

        }else {
            return new Response("1","2022-10-10");

        }
    }

    @Override
    public Response cancelPayment(int billType, String memberCode, double amount,int paymentId,Date billDate) {

            return new Response("0","2022-10-10");
    }

}
