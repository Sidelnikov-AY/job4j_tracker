package ru.job4j.tracker;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Collections;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemTest {
    @Test
    public void whenSortedUp() {
        Item item1 = new Item(3, "ww");
        Item item2 = new Item(2, "qq");
        Item item3 = new Item(1, "aa");
        Item item4 = new Item(1, "cc");
        Item item5 = new Item(1, "bb");
        List<Item> items = Arrays.asList(item1, item2, item3, item4, item5);
        List<Item> result = Arrays.asList(item3, item5, item4, item2, item1);
        Collections.sort(items);
        Collections.sort(items, new SortByNameItem());
        assertThat(items, is(result));
    }

    @Test
    public void whenSortedDown() {
        Item item1 = new Item(3, "ww");
        Item item2 = new Item(2, "qq");
        Item item3 = new Item(1, "aa");
        Item item4 = new Item(1, "cc");
        Item item5 = new Item(1, "bb");
        List<Item> items = Arrays.asList(item5, item4, item3, item2, item1);
        List<Item> result = Arrays.asList(item1, item2, item4, item5, item3);
        Collections.sort(items, Collections.reverseOrder());
        Collections.sort(items, new SortByNameItem().reversed());
        assertThat(items, is(result));
    }
}