package ru.job4j.tracker;

public class FindByIDAction implements UserAction{
    private final Output out;

    public FindByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int itemId = input.askInt("Input item's id to find: ");
        Item findItem = tracker.findById(itemId);
        if (findItem != null) {
            out.println("Найдена заявка: " + findItem);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
