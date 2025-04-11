package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class School {
    private List<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printStudents() {
        System.out.println("Students:");
        for (Student student: students) {
            System.out.println("ID: " + student.id());
            System.out.println("Name: " + student.firstname() + ' ' + student.lastname() + "\n");
        }
    }

    public Optional<Student> findStudent(int id) {
        for (Student student : students) {
            if (student.id() == id) return Optional.of(student);
        }
        return Optional.empty();
    }

    public Optional<Student> findStudentOrThrowError(int id) throws InvalidIDException {
        for (Student student : students) {
            if (student.id() == id) {
                return Optional.of(student);
            } else {
                throw new InvalidIDException("ID notfound!");
            }
        }
        return Optional.empty();
    }

    public void removeStudent(int id) {
        Optional<Student> student = findStudent(id);
        student.ifPresent(value -> this.students.remove(value));
    }

    public void showCoursesOfStudent(int id) {
        for (Student student : students) {
            if (student.id() == id) {
                System.out.println(student.firstname() + " " + student.lastname());
                student.courses().forEach(course -> {
                    System.out.println(course.name());
                });
                System.out.println("\n");
            }
        }
    }
}
