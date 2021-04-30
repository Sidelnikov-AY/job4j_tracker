package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] text = {"one", "two", "three", "four"};
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare - " + left + " : " + right + " result: ");
            return left.compareTo(right);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        Arrays.sort(text, cmpText);
        for (String s
                : text) {
            System.out.println(s);
        }
        Arrays.sort(text, cmpDescSize);
        for (String s
                : text) {
            System.out.println(s);
        }
    }
}
