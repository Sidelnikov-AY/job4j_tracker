package ru.job4j.collection;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (Object name : names) {
            System.out.println(name);
        }

    }
}
