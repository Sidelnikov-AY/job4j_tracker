package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveStream {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(-1);
        list.add(4);
        list.add(5);
        list.add(9999);
        list.add(0);
        list.add(-9);
        list.add(6);

        List<Integer> positive = list.stream().filter(
                number -> number >= 0).collect(Collectors.toList());
        for (Integer num: positive) {
            System.out.println(num);
        }
    }

}
