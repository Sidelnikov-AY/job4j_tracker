package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static List<String> deckGenerate() {
        List<String> deck = Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values())
                .map(value1 -> suit1 + " " + value1))
                .collect(Collectors.toList());

        deck.forEach(System.out::println);
        return deck;

    }
}

