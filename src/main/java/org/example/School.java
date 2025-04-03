package org.example;

import java.util.ArrayList;
import java.util.List;

public class School {
    static List<Student> students = new ArrayList();

    public static void addStudent(Student student) {
        students.add(student);
    }
}
