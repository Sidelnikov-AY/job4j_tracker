package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentMap {
    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream().
                collect(
                        Collectors.toMap(
                                Student::getSurname,
                                student -> student,
                                (first, second) -> first
                        )
                );
    }

}
