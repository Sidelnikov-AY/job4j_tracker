package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void givenNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public String sound() {
        String voice = "may - may";
        return voice;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.givenNick("Gav");
        gav.show();
        Cat black = new Cat();
        black.givenNick("Black");
        black.eat("fish");
        black.show();
    }
}
