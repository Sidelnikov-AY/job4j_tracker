package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String leftSplit = left.split("[.]")[0];
        String rightSplit = right.split("[.]")[0];
        return Integer.compare(Integer.parseInt(leftSplit), Integer.parseInt(rightSplit));
    }
}