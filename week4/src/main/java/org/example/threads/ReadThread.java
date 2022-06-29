package org.example.threads;

import org.example.models.Student;
import org.example.services.ThreadService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadThread extends Thread implements Runnable{
    static List<Student> studentList=new ArrayList<>();
    static String path=""; //Dosya yolu için değişken

    public ReadThread(String path) {
        this.path = path;
    }

    public static List<Student> readToJson(){ // Json dosyasından Student listelerini okuma metodu

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            //Dosya okunuyor
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject= (JSONObject) obj;
            JSONArray dataList = (JSONArray) jsonObject.get("students");//Student objesi içindeki Student listesi alınıyor.
            System.out.println("Reading is completed.");
            System.out.println(jsonObject.get("students"));
            Thread.sleep(3000);
            for(Object o: dataList){
                if ( o instanceof JSONObject ) {
                    parseEmployeeObject((JSONObject)o);// Alınan Student listesi tek tek Student objesine dönüştürülüyor.
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return studentList;

    }
    private static void parseEmployeeObject(JSONObject jsonObject) { //Jsonobject verisini Student modeline dönüştürüp student listesine ekleniyor.
        Student student=new Student();
        student=student.fromJson( jsonObject);
        studentList.add(student);
        System.out.println(student);

    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(ThreadService.isWrite){// Yazma tamamlanmadan okuma işlemi yapılmaması kontrolü
            System.out.println("Reading is in progress...");
            readToJson();
        }
    }
}
