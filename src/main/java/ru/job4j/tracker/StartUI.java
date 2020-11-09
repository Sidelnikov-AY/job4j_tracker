package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item first = new Item();
        LocalDateTime currentTime = first.getCreatedTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormatted = currentTime.format(formatter);
        System.out.println(currentDateTimeFormatted);
        first.setName("One");

        Tracker trackerOne = new Tracker();
        trackerOne.add(first);
        Item testOutput = trackerOne.findById(1);
        System.out.println(testOutput);

    }
}