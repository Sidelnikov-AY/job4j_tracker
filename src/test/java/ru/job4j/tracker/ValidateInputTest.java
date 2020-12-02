package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenOkInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenOkExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
                actions.add(new Exit(out));

        ValidateInput input = new ValidateInput(out, in);
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit Program ===%n"
                )
        ));
    }

    @Test
    public void whenInvalidInputTwo() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
            actions.add(new CreateAction(out));
            actions.add(new Exit(out));

        ValidateInput input = new ValidateInput(out, in);
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Create ===" + System.lineSeparator() +
                        "1. === Exit Program ===" + System.lineSeparator() +
                        "Please enter validate data again." + System.lineSeparator()
        ));
    }

}

