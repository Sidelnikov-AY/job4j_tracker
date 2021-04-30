package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentMapTest {
    @Test
    public void whenMapGenerate() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(10, "Surname1"),
                new Student(10, "Surname1"),
                new Student(10, "Surname2"),
                new Student(20, "Surname3"),
                new Student(30, "Surname4"),
                new Student(40, "Surname5")
        );
        Map<String, Student> expected = new HashMap<>();
        for (Student student : students) {
            expected.put(student.getSurname(), student);
        }
        StudentMap sm = new StudentMap();
        Map<String, Student>  rsl = sm.collectToMap(students);
        assertThat(rsl, is(expected));
    }
}