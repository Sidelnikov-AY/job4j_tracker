package ru.job4j.tracker;

import javax.swing.*;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size];
        for(int index = 0; index < size; index++) {
            Item item = items[index];
            if(item != null) {
                itemsWithoutNull[index] = item;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsOfKey = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                itemsOfKey[index] = item;
            }
        }
        itemsOfKey = Arrays.copyOf(itemsOfKey, size);
        return itemsOfKey;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}