package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void move() {
        System.out.println("Поехали!");

    }

    @Override
    public void passengers(int passengers) {
        System.out.println("У вокзала остановите!");

    }

    @Override
    public int fillUp(int fuel) {
        return fuel * 45;
    }
}
