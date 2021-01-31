package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (el.length() == 2) {
                    start += el;
                } else {
                    start = start + "/" + el;
                }
                tmp.add(start);

            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Comparator<String> dep = new DepDescComp();
        orgs.sort(dep);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<String> deps = Arrays.asList("K1/SK1/SSK1");
        System.out.println("Исходный массив: " + deps);
        System.out.println("Обработанный массив: " + fillGaps(deps));
    }
}

