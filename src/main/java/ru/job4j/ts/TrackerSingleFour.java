package ru.job4j.ts;

public class TrackerSingleFour {
    private TrackerSingleFour() {
    }

    public static TrackerSingleFour getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleFour INSTANCE = new TrackerSingleFour();
    }


    public static void main(String[] args) {
        TrackerSingleFour tracker = TrackerSingleFour.getInstance();
        System.out.println(tracker);
    }
}
