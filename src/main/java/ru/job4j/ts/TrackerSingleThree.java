package ru.job4j.ts;

public class TrackerSingleThree {
    private static final TrackerSingleThree INSTANCE = new TrackerSingleThree();

    private TrackerSingleThree() {
    }

    public static TrackerSingleThree getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        TrackerSingleThree tracker = TrackerSingleThree.getInstance();
        System.out.println(tracker);
    }
}
