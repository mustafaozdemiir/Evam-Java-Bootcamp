package com.week2.services;

public class MemberAccountService {
// MemberAccount için crud işlem metodları oluşturuldu.
    public static void create(MemmberAccount member){
        System.out.println("Üye hesabı oluşturuldu.");
    }
    public static void read(){
        System.out.println("Üye bilgileri getirildi.");
    }
    public static void update(MemmberAccount member,MemmberAccount newMember){
        System.out.println("Üye bilgileri güncellendi.");
    }
    public static void delete(MemberAccount member){
        System.out.println("Üye silindi.");
    }
}
