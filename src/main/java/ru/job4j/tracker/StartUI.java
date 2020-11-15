package ru.job4j.tracker;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] showItem = tracker.findAll();
                for (Item item : showItem) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                int itemId = Integer.valueOf(input.askStr("Input item's id to change: "));
                String newItemName = input.askStr("Input item's name: ");
                Item newItem = new Item(newItemName);
                if (tracker.replace(itemId, newItem)) {
                    System.out.println("Operation complete");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 3) {
                int itemId = Integer.valueOf(input.askStr("Input item's id to delete: "));
                if (tracker.delete(itemId)) {
                    System.out.println("Operation complete");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                int itemId = Integer.valueOf(input.askStr("Input item's id to find: "));
                Item findItem = tracker.findById(itemId);
                if (findItem != null) {
                    System.out.println("Найдена заявка: " + findItem);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                String findItemName = input.askStr("Input item's name to find: ");
                Item[] foundItems = tracker.findByName(findItemName);
                if (foundItems.length > 0) {
                    for (Item item : foundItems) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            }
        }


    }
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    public static void main(String[] args) {
        Item first = new Item();
        LocalDateTime currentTime = first.getCreatedTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormatted = currentTime.format(formatter);
        //System.out.println(currentDateTimeFormatted);

       Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);


    }
}
