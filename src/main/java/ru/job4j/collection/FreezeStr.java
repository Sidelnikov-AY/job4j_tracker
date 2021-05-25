package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftCharArray = left.toCharArray();
        char[] rightCharArray = right.toCharArray();
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();

        for (char c : leftCharArray) {
            int counter = 1;
            if (leftMap.containsKey(c)) {
                counter = leftMap.get(c);
                counter++;
            }
            leftMap.put(c, counter);
        }

        for (char c : rightCharArray) {
            int counter2 = 1;
            if (rightMap.containsKey(c)) {
                counter2 = rightMap.get(c);
                counter2++;
            }
            rightMap.put(c, counter2);
        }

        if (rightMap.size() != leftMap.size()) {
            return false;
        }
        for (char c : leftMap.keySet()) {
            if (!rightMap.containsKey(c) || !leftMap.get(c).equals(rightMap.get(c))) {
                return false;
            }
        }
        return true;
    }
}