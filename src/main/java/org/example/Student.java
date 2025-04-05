package org.example;

import java.util.List;

public record Student(
        int id,
        String firstname,
        String lastname,
        List<Course> courses
        ) {

        public void setCourse(Course course) {
                this.courses.add(course);
        }
}
