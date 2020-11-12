package ru.job4j.io;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int match;
        int matchNumbers = 11;
        boolean run = true;
        int step = 1;
        System.out.println("Игра одиннадцать");
        while (run) {
            if (step % 2 != 0) {
                System.out.println("Первый игрок возьмите от 1 до 3 спичек");
                match = Integer.valueOf(input.nextLine());
                matchNumbers -= match;
                if (matchNumbers > 0) {
                    System.out.println("На столе осталось: " + matchNumbers + " спичек");
                    step++;
                } else {
                    System.out.println("Победил первый игрок");
                    run = false;
                }
            } else if (step % 2 == 0) {
                System.out.println("Второй игрок возьмите от 1 до 3 спичек");
                match = Integer.valueOf(input.nextLine());
                matchNumbers -= match;
                System.out.println("На столе осталось: " + matchNumbers + " спичек");
                step++;
                    if (matchNumbers <= 0) {
                        System.out.println("Победил второй игрок");
                        run = false;
                    }
            }
        }
        System.out.println("Игра окончена");
    }
}
