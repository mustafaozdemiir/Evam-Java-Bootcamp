package org.example;

import org.example.models.Student;

import org.example.threads.ReadThread;
import org.example.threads.WriteThread;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Student listesi oluşturuluyor
        List<Student> studentList=new ArrayList<Student>(){{
               add (new Student("Mustafa","ÖZDEMİR",25));
               add (new Student("Ahmet","YILDIZ",13));
               add (new Student("Mehmet","YARAR",45));}};

        //Thread leri oluşturuluyor
         Thread writeThread=new WriteThread(studentList);
         Thread readThread=new ReadThread("student_list.json");

         //Thread lar başlatılıyor.
        writeThread.start();
        readThread.start();
    }
}