package ru.job4j.collection;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> setFromOrigin = new HashSet<>();
        List<String> inOrigin = new ArrayList<>(Arrays.asList(origin.split("\\s|,|!|;|:|\\.")));
        setFromOrigin.addAll(inOrigin);
        List<String> inLine = new ArrayList<>(Arrays.asList(line.split(" ")));
        boolean check = true;
        for (String word : inLine) {
            if (!setFromOrigin.contains(word)) {
                check = false;
                break;
            }
        }
        return check;
    }
}
