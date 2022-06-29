package org.example.models;

import org.json.simple.JSONObject;

public class Student {
    private String name;
    private String surname;
    private int age;

    // Constructors, Getters, Setters
    public Student() {
    }
    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Student objesini JsonObject e çevirme metodu
    public JSONObject toJson(){
        JSONObject dataObject = new JSONObject();
        if(this.name.isEmpty()||this.surname.isEmpty()||this.age<=0){
            System.out.println("Error : Missing information");
            return null;
        }else{
            dataObject.put("name", this.name);
            dataObject.put("surname", this.surname);
            dataObject.put("age", this.age);
            return dataObject;
        }
    }

    //Jsonobject olarak gelen data yı Student nesnesine dönüştürme metodu
    public Student fromJson(JSONObject studentJsonObject){
        Student student;
        if(studentJsonObject!=null&&!studentJsonObject.isEmpty()){
            student=new Student((String) studentJsonObject.get("name"), (String) studentJsonObject.get("surname"), Integer.parseInt( studentJsonObject.get("age").toString()));
        }else {
            return null;
        }
        return student;

    }

    // Student objesinin String yazdırma metodu
    public String toString(){
        return "Name: "+this.name+" Surname: "+this.surname+" Age: "+this.age;
    }

}
