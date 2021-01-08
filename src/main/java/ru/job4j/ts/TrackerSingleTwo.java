package ru.job4j.ts;

public class TrackerSingleTwo {
    private static TrackerSingleTwo instance;

    private TrackerSingleTwo() {
    }

    public static TrackerSingleTwo getInstance() {
        if (instance == null) {
            instance = new TrackerSingleTwo();
        }
        return instance;
    }

    public static void main(String[] args) {
        TrackerSingleTwo tracker = TrackerSingleTwo.getInstance();
        System.out.println(tracker);
    }
}
