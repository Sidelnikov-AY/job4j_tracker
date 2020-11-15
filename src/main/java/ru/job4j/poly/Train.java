package ru.job4j.poly;

public class Train implements Venicle {
    int mspeed = 120;

    public Train() {
    }

    public Train(int mspeed) {
        this.mspeed = mspeed;
    }

    @Override
    public void move() {
        System.out.println("ТУ-ТУ-ТУУ!");

    }

    @Override
    public void maxSpeed(int speed) {
        System.out.println("Максимальаня скорость: " + this.mspeed);

    }
}
