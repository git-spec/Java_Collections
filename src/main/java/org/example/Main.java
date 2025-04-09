package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(
                                123456,
                                "Max",
                                "Mustermann",
                                20,
                                new ArrayList<>()
                        ),
                        new Student(
                                789101,
                                "Erika",
                                "Mustermann",
                                19,
                                new ArrayList<>()
                        ),
                        new Student(
                                111213,
                                "Jon",
                                "Doe",
                                22,
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
        Telephone.book.forEach( (k, v) -> System.out.println(k + " -> " + v));
        System.out.println(' ');
        System.out.println(Telephone.getSize());
        System.out.println(' ');
        Telephone.deleteByName("John");
        Telephone.book.forEach( (k, v) -> System.out.println(k + " -> " + v));
        System.out.println(' ');
        Telephone.deleteAll();
        Telephone.book.forEach( (k, v) -> System.out.println(k + " -> " + v));

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(new Medication("Thomapyrin Intensiv", 6.29, true));
        pharmacy.save(new Medication("Spalt", 11.45, false));
        pharmacy.save(new Medication("IBUPROFEN", 4.01, true));
        pharmacy.showAll();

        /** STREAM **/
        List<Student> result;
        try (Stream<String> x = Files.lines(Path.of("students.csv"))) {
            result = x
                    .skip(1)
                    .filter(s -> !s.isEmpty())
                    .distinct()
                    .map(s -> s.split(","))
                    .map(s -> new Student(
                            Integer.parseInt(s[0]),
                            s[1],
                            s[2],
                            Integer.parseInt(s[3]),
                            new ArrayList<>()
                            )
                        ).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result.forEach(s -> {
            System.out.println("ID: " + s.id());
            System.out.println("Name: " + s.firstname() + ' ' + s.lastname());
            System.out.println("Age: " + s.age() + "\n");
        });
    }
}