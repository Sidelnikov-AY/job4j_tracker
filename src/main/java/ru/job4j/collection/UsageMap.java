package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("map@map.ru", "Vasiliy Vasilyevich Valivyev");
        map.put("map2@map.ru", "Ivan Vasilyevich Valivyev");
        for (String key : map.keySet()
             ) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
