package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Optional<Student> student = school.findStudent(123456);
        if (student.isPresent()) {
            System.out.println(student.get().firstname() + " " + student.get().lastname() + "\n");
        } else {
            System.out.println("No student found with id 123457.\n");
        }

        school.showCoursesOfStudent(123456);

        /** MAP **/
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

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(new Medication("Thomapyrin Intensiv", 6.29, true));
        pharmacy.save(new Medication("Spalt", 11.45, false));
        pharmacy.save(new Medication("IBUPROFEN", 4.01, true));
        pharmacy.showAll();
    }
}