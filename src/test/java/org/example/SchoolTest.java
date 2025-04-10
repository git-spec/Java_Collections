package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    @Test
    void findStudent_shouldReturnStudent_whenFoundWithID() {
        // GIVEN
        int id = 123456;
        Student expected = new Student(
                123456,
                "Max",
                "Mustermann",
                21,
                new ArrayList<>()
        );
        // WHEN
        School school = new School();
        school.addStudent(expected);
        Optional<Student> actual = school.findStudent(id);
        // THEN
        actual.ifPresent(student -> assertEquals(expected, student));
    }
    @Test
    void findStudent_shouldReturnNull_whenNotFoundWithID() {
        // GIVEN
        int id = 123457;
        // WHEN
        School school = new School();
        Optional<Student> actual = school.findStudent(id);
        // THEN
        assertNull(actual.orElse(null));
    }

    @Test
    void removeStudent_shouldReturnSmallerSize_whenRemoveWithID() {
        // GIVEN
        int id = 123456;
        Student expected = new Student(
                123456,
                "Max",
                "Mustermann",
                21,
                new ArrayList<>()
        );
        // WHEN
        School actual = new School();
        actual.addStudent(expected);
        actual.removeStudent(id);
        // THEN
        assertFalse(actual.getStudents().contains(expected));
    }
}