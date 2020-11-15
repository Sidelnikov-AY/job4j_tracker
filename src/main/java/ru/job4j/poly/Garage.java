package ru.job4j.poly;

public class Garage {
    public static void main(String[] args) {
        Venicle airbus = new Plane();
        Venicle sapsan = new Train();
        Venicle ikarusGarmoshka = new Bus(100);

        Venicle[] venicls = new Venicle[]{airbus, sapsan, ikarusGarmoshka};
        for (Venicle v : venicls) {
            v.move();
            v.maxSpeed(0);
        }

    }
}
