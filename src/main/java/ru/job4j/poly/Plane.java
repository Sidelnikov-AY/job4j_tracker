package ru.job4j.poly;

public class Plane implements Venicle {
    int mspeed = 750;

    public Plane() {
    }

    public Plane(int mspeed) {
        this.mspeed = mspeed;
    }



    @Override
    public void move() {
        System.out.println("У-У-У-У!");
    }

    @Override
    public void maxSpeed(int mspeed) {
        System.out.println("Максимальаня скорость: " + this.mspeed);

    }
}
