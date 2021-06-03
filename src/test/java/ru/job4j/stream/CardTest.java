package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.stream.Card.deckGenerate;

public class CardTest {

    @Test
    public void whenDeckGenerate() {
        List<String> rsl = deckGenerate();
        List<String> expected = List.of("Diamonds V_6", "Diamonds V_7",
                "Diamonds V_8", "Hearts V_6", "Hearts V_7",
                "Hearts V_8", "Spades V_6", "Spades V_7",
                "Spades V_8", "Clubs V_6", "Clubs V_7", "Clubs V_8");
        assertThat(rsl, is(expected));
    }
}