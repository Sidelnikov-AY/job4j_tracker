package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int itemId = input.askInt("Input item's id to change: ");
        String newItemName = input.askStr("Input item's name: ");
        Item newItem = new Item(newItemName);
        if (tracker.replace(itemId, newItem)) {
            System.out.println("Operation complete");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
