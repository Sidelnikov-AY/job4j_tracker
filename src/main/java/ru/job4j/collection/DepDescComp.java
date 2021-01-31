package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        int rsl = left[0].compareTo(right[0]);
        rsl = rsl == 0 ? rsl = o1.compareTo(o2): rsl;
        return rsl;
    }
}
