package org.example.threads;

import org.example.models.Student;
import org.example.services.ThreadService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteThread extends Thread implements Runnable{ //Öğrenci listelerini parametre olarak alan sınıf
    static List<Student> studentList =new ArrayList<>();

    public WriteThread(List<Student> studentList) {
        this.studentList = studentList;
    }

    public static void writeToJson(){ // Gelen Student listesini student_list.json dosyası olarak yazan metod
        ThreadService.isWrite=false; //Yazma durumu kontrol değişkeni


        JSONArray studentJSONArrayList = new JSONArray();

        for (Student student: studentList){ //Jsonarray e Student lar Json objesine dönüştürülüp ekleniyor.
            JSONObject studentJSONObject=new JSONObject();
            studentJSONObject=student.toJson();
            studentJSONArrayList.add(studentJSONObject);
        }

        JSONObject jsonObject =new JSONObject();
        jsonObject.put("students",studentJSONArrayList);

        try (FileWriter file = new FileWriter("student_list.json")) { //student_list.json isminde dosya oluşuyor ve içine oluşan json ekleniyor ve yazılıyor.

            file.write(jsonObject.toJSONString());
            file.flush();
            ThreadService.isWrite=true; //Yazma kontrolü işlem bitince açılıyor.

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Writing is in progress...");
        writeToJson();
        System.out.println("Writing is completed.");
    }
}
