package ru.job4j.ts;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleOneTest {

    @Test
    public void whenTrackerSingleOneIsOne() {
        TrackerSingleOne tracker1 = TrackerSingleOne.INSTANCE;
        TrackerSingleOne tracker2 = TrackerSingleOne.INSTANCE;
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerSingleTwoIsOne() {
        TrackerSingleTwo tracker1 = TrackerSingleTwo.getInstance();
        TrackerSingleTwo tracker2 = TrackerSingleTwo.getInstance();
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerSingleThreeIsOne() {
        TrackerSingleThree tracker1 = TrackerSingleThree.getInstance();
        TrackerSingleThree tracker2 = TrackerSingleThree.getInstance();
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerSingleFourIsOne() {
        TrackerSingleFour tracker1 = TrackerSingleFour.getInstance();
        TrackerSingleFour tracker2 = TrackerSingleFour.getInstance();
        assertSame(tracker1, tracker2);
    }
}