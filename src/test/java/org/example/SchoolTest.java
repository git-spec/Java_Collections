package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    @Test
    void findStudent_shouldReturnStudent_whenFoundWithID() {
        // GIVEN
        int id = 12345678;
        Student expected =  new Student(
                123456,
                "Max",
                "Mustermann"
        );
        // WHEN
        Student actual = School.findStudent(id);
        // THEN
        assertEquals(expected, actual);
    }
}