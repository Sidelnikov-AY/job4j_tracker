package ru.job4j.tracker;

public class FindAllAction implements UserAction{
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] showItem = tracker.findAll();
        for (Item item : showItem) {
            System.out.println(item);
        }
        return true;
    }
}
