package ru.job4j.tracker;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            //System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] showItem = tracker.findAll();
                showItem = tracker.findAll();
                for (Item item : showItem) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("Input item's id to change");
                int itemId = Integer.valueOf(scanner.nextLine());
                System.out.println("Input item's name:");
                String newItemName = scanner.nextLine();
                Item newItem = new Item(newItemName);
                if (tracker.replace(itemId, newItem)) {
                    System.out.println("Operation complete");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 3) {
                System.out.println("Input item's id to delete");
                int itemId = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(itemId)) {
                    System.out.println("Operation complete");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("Input item's id to find");
                int itemId = Integer.valueOf(scanner.nextLine());
                Item findItem = tracker.findById(itemId);
                if (findItem != null) {
                    System.out.println("Найдена заявка: " + findItem);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("Input item's name to find:");
                String findItemName = scanner.nextLine();
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
        System.out.print("Select:");
    }

    public static void main(String[] args) {
        Item first = new Item();
        LocalDateTime currentTime = first.getCreatedTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormatted = currentTime.format(formatter);
        //System.out.println(currentDateTimeFormatted);

        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);


    }
}
