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

        Telephone.add("John", 01618795463d);
        Telephone.add("Lisa", 01753495741d);
        Telephone.add("Gerald", 01671123655d);
        Telephone.book.forEach( (k, v) -> { System.out.println(k + " -> " + v); } );
        System.out.println(' ');
        System.out.println(Telephone.getSize());
        System.out.println(' ');
        Telephone.deleteByName("John");
        Telephone.book.forEach( (k, v) -> { System.out.println(k + " -> " + v); } );
        System.out.println(' ');
        Telephone.deleteAll();
        Telephone.book.forEach( (k, v) -> { System.out.println(k + " -> " + v); } );
    }
}