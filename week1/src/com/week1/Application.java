package com.week1;

import java.util.Scanner;

public class Application {

    String s1="Welcome"; // Obje 1
    String s2="Welcome"; // Obje 2
    String s3="Welcome"; // Obje 3
    // 3 Farklı nesne (Object) oluşturuluyor. Ama işaret ettiği alanlar Aynı alanlardır.
    static String checkValue ="<<code>>";

    static String[] stringArray = {"Mustafa","Mahmut","<<code>>","Fatma","Veysel"}; //statik olarak string dizisi oluşturuldu.

    public static void main(String[] args){
        //İlk olarak kullanıcıdan string ifadeleri almak için olan getInputStringArray fonksiyonu ile 5 adet String değer alıyoruz.
        //Bu alınan Stringlerden oluşan diziyi parametre olarak alan checkString fonskiyonuna parametre olarak gönderip içerinde aranan value olup olmadığını geri döndürülüyor.
        //Geri dönen bu değeri println ile ekrana yazdırıyoruz.
        System.out.println("Tanımlı value yu içeren String deger: "+checkString(getInputStringArray(5)));
    }

    //String dizi olarak parametre alan fonsiyonun uzunluğu kadar döngüye girip static olarak aranan value yi içerip içermediği kontrol ediliyor. Var ise içeren değer geri döndürülüyor içermiyor ise not found mesajı döndürülüyor.
    public static String checkString(String[] stringArray){
        for(String value: stringArray){
            if(value.contains(checkValue)){
                return value;
            }
        }
        return "Value not found";
    }
    //Kaç adet string veri alınacaksa parametre olarak alan fonksiyon oluşturuldu.
    public static String[] getInputStringArray(int arrayLength){
        String[] arrays=new String[arrayLength];
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almamızı sağlayan Scanner sınıfından nesne oluşturuldu.
        System.out.println("Enter "+ arrayLength +" string values.");

        for (int i = 0; i < arrays.length; i++) {// İstenilen uzunluk kadar döngüde oluşturulan diziye kullanıcıdan sırayla veriler alındı.
            System.out.print("Value of " +(i+1)+" \n");
            arrays[i] = scanner.nextLine();
        }
        return arrays; // Alınan dizi geri dönüş olarak gönderildi.
    }
}
