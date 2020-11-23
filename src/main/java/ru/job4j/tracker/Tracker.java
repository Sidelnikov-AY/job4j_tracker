package ru.job4j.tracker;

import javax.swing.*;
import java.util.Arrays;

// 1-ый способ создания Singleton - через enum
public enum Tracker {
    INSTANCE;

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    // 2-ый способ создания Singleton - создаем и инициализируем объект
//    public class Tracker() {
//    private static final Tracker INSTANCE = new Tracker();
//    private Tracker() {
//    }
//    public static Tracker getInstance() {
//        return INSTANCE;
//    }

    // 3-ый способ создания Singleton - в поле внутреннего класса
//    public class Tracker() {
//        private Tracker() {
//        }
//        public static Tracker getInstance() {
//            return Holder.INSTANCE;
//        }
//        private static final class Holder {
//            private static final Tracker INSTANCE = new Tracker();
//        }

    // 4-ый способ создания Singleton - через конструктор по умолчанию с модиф. private
//    public class Tracker() {
//    private static Tracker instance;
//    private Tracker() {
//    }
//
//    public static Tracker getInstance() {
//        if (instance == null) {
//            instance = new Tracker();
//        }
//        return instance;
//    }


    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsOfKey = new Item[size];
        int index2 = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                itemsOfKey[index2++] = item;
            }
        }
        itemsOfKey = Arrays.copyOf(itemsOfKey, index2);
        return itemsOfKey;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
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
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}