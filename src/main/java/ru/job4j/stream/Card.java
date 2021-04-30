package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .forEach(value -> Stream.of(Value.values())
                            .forEach(suit -> System.out.println(value + " " + suit)));
    }
}

