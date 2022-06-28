import models.Student;
import services.PrioritiesServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner scan = new Scanner(System.in); // Klavyeden veri almak için Scanner sınıfı nesnesi oluşturuluyor.
    private final static PrioritiesServices prioritiesServices = new PrioritiesServices(); // Servis class ından nesne oluştuluyor. getStudent fonksiyonun kullanmak için

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();// Komutlar alınıyor
            events.add(event);
        }
        List<Student> students = prioritiesServices.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("Queue is empty"); // Boş kaldı ise bilgi veriliyor.
        } else {
            System.out.println("RESULT");
            for (Student st : students) {   // Öğrencinin adlarını yazılıyor.
                System.out.println(st.getName());
            }
        }
    }
}