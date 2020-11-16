package ru.job4j.tracker;

import ru.job4j.inheritance.TextReport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void  findAllItem(Input input, Tracker tracker) {
        Item[] showItem = tracker.findAll();
        for (Item item : showItem) {
            System.out.println(item);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int itemId = input.askInt("Input item's id to change: ");
        String newItemName = input.askStr("Input item's name: ");
        Item newItem = new Item(newItemName);
        if (tracker.replace(itemId, newItem)) {
            System.out.println("Operation complete");
        } else {
            System.out.println("Error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int itemId = input.askInt("Input item's id to delete: ");
        if (tracker.delete(itemId)) {
            System.out.println("Operation complete");
        } else {
            System.out.println("Error");
        }
    }
    public static void  findItemById(Input input, Tracker tracker) {
        int itemId = input.askInt("Input item's id to find: ");
        Item findItem = tracker.findById(itemId);
        if (findItem != null) {
            System.out.println("Найдена заявка: " + findItem);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String findItemName = input.askStr("Input item's name to find: ");
        Item[] foundItems = tracker.findByName(findItemName);
        if (foundItems.length > 0) {
            for (Item item : foundItems) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItem(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);;
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
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
