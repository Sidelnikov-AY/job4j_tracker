package ru.job4j.tracker;

public class FindByIDAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int itemId = input.askInt("Input item's id to find: ");
        Item findItem = tracker.findById(itemId);
        if (findItem != null) {
            System.out.println("Найдена заявка: " + findItem);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
