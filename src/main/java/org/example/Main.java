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
                                "Mustermann",
                                new ArrayList<>()
                        ),
                        new Student(
                                789101,
                                "Erika",
                                "Mustermann",
                                new ArrayList<>()
                        ),
                        new Student(
                                111213,
                                "Jon",
                                "Doe",
                                new ArrayList<>()
                        )
                )
        );
        School school = new School();

        for (Student student: students) {
            if (student.firstname().equals("Max")) {
                student.setCourse(
                    new Course(
                            "Mathematik",
                            "Gaussen",
                            "C-322"
                    )
                );
                student.setCourse(
                        new Course(
                                "Sport",
                                "Dreibold",
                                "C-600"
                        )
                );
            }
            if (student.firstname().equals("Erika")) student.setCourse(
                    new Course(
                            "Englisch",
                            "Smith",
                            "C-756"
                    )
            );
            school.addStudent(student);
        }

        school.printStudents();

        Student student = school.findStudent(123456);
        if (student != null) {
            System.out.println(student.firstname() + " " + student.lastname() + "\n");
        } else {
            System.out.println("No student found with id 123457.\n");
        }

        school.showCoursesOfStudent(123456);
    }
}