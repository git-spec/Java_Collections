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
            if (student.id() == id) return Optional;
        }
        return Optional.empty();
    }

    public void removeStudent(int id) {
        this.students.remove(findStudent(id));
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
