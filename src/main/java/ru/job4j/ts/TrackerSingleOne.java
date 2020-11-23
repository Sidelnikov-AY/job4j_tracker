package ru.job4j.ts;

public enum TrackerSingleOne {
    INSTANCE;

    public static void main(String[] args) {
        System.out.println(TrackerSingleOne.INSTANCE);
    }
}
