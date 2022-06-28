package services;

import models.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrioritiesServices {// Kuyruk yapısının işlendiği servis class ı
    PriorityQueue<Student> queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed() //Comparator ile kuyruk sırasının oluşturulma şartlarını belirtiyoruz.
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getId));

    public List<Student> getStudents(List<String> events){
        events.forEach((event) -> {
            if (event.equals("SERVED")) {// Served komutu gelmediği sürece öğrenci eklenme komutu olacağı için served ise poll metodu ile çekim yapılıyor.
                queue.poll();
            } else {
                String[] details = event.split(" ");
                System.out.println(details[1]+" "+ Double.parseDouble(details[2])+" "+Integer.parseInt(details[3]));
                queue.add(new Student( details[1], Double.parseDouble(details[2]),Integer.parseInt(details[3])));// Boşluklara göre komutu bölüyoruz sırasına göre Student nesnesi oluşturuluyor.
            }
        });

        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }
        return students;
    }
}
