package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan Ivanich");
        student.setGroup("I-12345");
        student.setDate(new Date());

        System.out.println(student.getName() + " : " + student.getGroup() + " : " + student.getDate());
    }
}
