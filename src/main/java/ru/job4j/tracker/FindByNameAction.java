package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findItemName = input.askStr("Input item's name to find: ");
        List<Item> foundItems = tracker.findByName(findItemName);
        if (foundItems.size() > 0) {
            for (Item item : foundItems) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем: " + findItemName + " не найдены");
        }
        return true;
    }
}
