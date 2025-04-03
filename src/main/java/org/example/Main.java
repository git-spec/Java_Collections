package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(
                                123456,
                                "Max",
                                "Mustermann"
                        ),
                        new Student(
                                789101,
                                "Erika",
                                "Mustermann"
                        ),
                        new Student(
                                111213,
                                "Jon",
                                "Doe"
                        )
                )
        );

        for (Student student: students) {
            School.addStudent(student);
        }

        School.printStudents();
    }
}