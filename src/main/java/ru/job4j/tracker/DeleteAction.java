package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    private final Output out;

    public DeleteAction(Output out) {
    this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int itemId = input.askInt("Input item's id to delete: ");
        if (tracker.delete(itemId)) {
            System.out.println("Operation complete");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
