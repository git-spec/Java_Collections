package org.example;

import java.util.ArrayList;
import java.util.List;

public class School {
    static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void printStudents() {
        System.out.println("Students:");
        for (Student student: students) {
            System.out.println("ID: " + student.id);
            System.out.println("Name: " + student.firstname + ' ' + student.lastname + "\n");
        }
    }
}
