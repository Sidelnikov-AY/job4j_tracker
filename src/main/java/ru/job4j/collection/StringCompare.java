package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int index = 0; index < Math.min(left.length(), right.length()); index ++) {
            char charLeft = left.charAt(index);
            char charRight = right.charAt(index);
            if (charLeft != charRight) {
                return charLeft - charRight;
            }
        }
        return left.length() - right.length();
    }
}
