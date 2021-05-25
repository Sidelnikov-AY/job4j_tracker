package ru.job4j.collection;


import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> setFromOrigin = new HashSet<>();
        origin = origin.replaceAll("\\p{P}", "");
        List<String> inOrigin = new ArrayList<>(Arrays.asList(origin.split(" ")));
        setFromOrigin.addAll(inOrigin);
        line = line.replaceAll("\\p{P}", "");
        String[] inLine = line.split(" ");
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
