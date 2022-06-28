package com.week2.services;

import com.week2.LowBalanceException;
import com.week2.models.Response;

import java.util.Date;

// interface oluşturuldu.
public interface Client {
      // inherite edilecek metodlar oluşturuldu. Geri dönüş değeri olarak Response türü verildi.
      Response payment(int billType, String memberCode,double balance, double amount) throws LowBalanceException; // LowBalanceException kullanılacak metodu belirttik.
      Response inquire(int billType,String memberCode);
      Response inquire(int billType, String memberCode, double amount, Date billDate);
      // Aynı isimde farklı parametreler alan metodlar oluşturuldu.
      Response cancelPayment(int billType, String memberCode, double amount,int paymentId,Date billDate);

}
