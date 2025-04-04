package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    @Test
    void findStudent_shouldReturnStudent_whenFoundWithID() {
        // GIVEN
        int id = 123456;
        Student expected = new Student(
                123456,
                "Max",
                "Mustermann"
        );
        // WHEN
        School school = new School();
        school.addStudent(expected);
        Student actual = school.findStudent(id);
        // THEN
        assertEquals(expected, actual);
    }
    @Test
    void findStudent_shouldReturnNull_whenNotFoundWithID() {
        // GIVEN
        int id = 123457;
        // WHEN
        School school = new School();
        Student actual = school.findStudent(id);
        // THEN
        assertNull(actual);
    }

    @Test
    void removeStudent_shouldReturnSmallerSize_whenRemoveWithID() {
        // GIVEN
        int id = 123456;
        Student expected = new Student(
                123456,
                "Max",
                "Mustermann"
        );
        // WHEN
        School school = new School();
        school.addStudent(student);
        Student actual = school.removeStudent(id);
        // THEN
        assertFalse(actual.students.contains(expected));
    }
}