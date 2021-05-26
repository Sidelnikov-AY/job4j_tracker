package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftCharArray = left.toCharArray();
        char[] rightCharArray = right.toCharArray();
        Map<Character, Integer> leftMap = new HashMap<>();

        for (char c : leftCharArray) {
            int counter = 1;
            if (leftMap.containsKey(c)) {
                counter = leftMap.get(c);
                counter++;
            }
            leftMap.put(c, counter);
        }
        for (char c : rightCharArray) {
            if (!leftMap.containsKey(c)) {
                return false;
            }
            if (leftMap.containsKey(c) && leftMap.get(c) > 1) {
                leftMap.put(c, leftMap.get(c) - 1);
            } else {
                leftMap.remove(c);
            }
        }
        return leftMap.isEmpty();
    }
}