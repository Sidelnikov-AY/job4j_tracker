package ru.job4j.poly;

public class Bus implements Venicle {
    private int mspeed = 90;

        public Bus() {
    }

    public Bus(int mspeed) {
        this.mspeed = mspeed;
    }

    @Override
    public void move() {
        System.out.println("Р-Р-Р!");

    }

    @Override
    public void maxSpeed(int speed) {
        System.out.println("Максимальаня скорость: " + this.mspeed);
    }

    public int getMspeed() {
        return mspeed;
    }

    public void setMspeed(int mspeed) {
        this.mspeed = mspeed;
    }
}


