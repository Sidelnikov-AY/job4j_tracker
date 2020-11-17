package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findItemName = input.askStr("Input item's name to find: ");
        Item[] foundItems = tracker.findByName(findItemName);
        if (foundItems.length > 0) {
            for (Item item : foundItems) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
