package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        Item item1 = tracker.add(new Item("New item1"));
        Item[] items = {item, item1};
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenItemFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        Item item1 = tracker.add(new Item("New item"));
        Item[] items = {item, item1};
        Input in = new StubInput(
                new String[] {"0", "New item", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findByName(item.getName()), is(items));

    }

    @Test
    public void whenItemFindById(){
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByIDAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(item));

    }

}