package ru.job4j.poly;

public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Гав-гав.");
    }
}
