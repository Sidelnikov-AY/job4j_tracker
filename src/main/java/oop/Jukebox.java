package oop;

import java.sql.SQLOutput;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        }   else if (position == 2) {
            System.out.println("Спокойной ночи");
            } else {
                System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox item = new Jukebox();
        item.music(1);
        item.music(2);
        item.music(42);
    }

}
