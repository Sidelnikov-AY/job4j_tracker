package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        rsl = students.keySet()
                .stream()
                .filter(s -> account.equals(s.getAccount()))
                        .findFirst();
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> stud = findByAccount(account);
        if (stud.isPresent()) {
            Set<Subject> subjects = students.get(stud.get());
            rsl = subjects.stream()
                    .filter(subj -> name.equals(subj.getName()))
                    .findFirst();
        }
        return rsl;
    }
}