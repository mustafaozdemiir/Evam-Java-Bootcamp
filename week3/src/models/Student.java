package models;

public class Student{
// Model class ı değerler ve getter setterları oluştuluyor.
    private int id;
    private String name;
    private double cgpa;

    public Student() {
    }
    // Constructorlar oluşturuldu.
    public Student( String name, double cgpa,int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }


}
