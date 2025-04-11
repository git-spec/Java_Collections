package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SchoolTest {
    School school;
    Student student;
    @BeforeAll
    public void setup() {
        school = new School();
        student = new Student(
                123456,
                "Max",
                "Mustermann",
                21,
                new ArrayList<>()
        );
        school.addStudent(student);
    }
    @Test
    void findStudent_shouldReturnStudent_whenFoundWithID() {
        // GIVEN
        int id = 123456;
        // WHEN
        Optional<Student> actual = school.findStudent(id);
        // THEN
        actual.ifPresent(value -> assertEquals(student, value));
    }
    @Test
    void findStudent_shouldReturnNull_whenNotFoundWithID() {
        // GIVEN
        int id = 123457;
        // WHEN
        Optional<Student> actual = school.findStudent(id);
        // THEN
        assertNull(actual.orElse(null));
    }

    @Test
    void removeStudent_shouldReturnSmallerSize_whenRemoveWithID() {
        // GIVEN
        int id = 123456;
        // WHEN
        school.removeStudent(id);
        // THEN
        assertFalse(school.getStudents().contains(student));
    }

    @Test
    void findStudentOrThrowError_shouldThrowException_whenWrongID_method1() {
        try {
            school.findStudentOrThrowError(674838);
            fail();
        } catch (InvalidIDException e) {
            // Success!
        }
    }

    @Test
    void findStudentOrThrowError_shouldThrowException_whenWrongID_method2() {
        assertThrows(InvalidIDException.class, () -> school.findStudentOrThrowError(674838));
    }
}