package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public enum Tracker {
    INSTANCE;

    List<Item> items = new ArrayList<Item>();
    private int ids = 1;
    private int size = 0;


    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(size++, item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> itemsOfKey = new ArrayList<Item>(size);
        int index2 = 0;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                itemsOfKey.add(index2++, item);
            }
        }
        itemsOfKey = List.copyOf(itemsOfKey);
        return itemsOfKey;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.add(index, null);
            Item[] arrayItems = items.toArray(new Item[items.size()]);
            System.arraycopy(arrayItems, index + 1, arrayItems, index, size - index);
            items.add(size - 1, null);
            size--;
        }
        return rsl;
    }
}