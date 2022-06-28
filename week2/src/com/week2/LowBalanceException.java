package com.week2;

public class LowBalanceException extends Exception{// Custom exception oluşturuldu ve Exception sınıfından extends edildi.
    String message; // getMessage metodu için değişken oluşturuldu.

    public LowBalanceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }


}
