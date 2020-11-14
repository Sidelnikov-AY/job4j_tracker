package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int match = 0;
        int matchNumbers = 11;
        int step = 1;
        String player = "";
        System.out.println("Игра одиннадцать");
        while (matchNumbers > 0) {
            if (step % 2 != 0) {
                player = "Первый";
            } else {
                player = "Второй";
            }
            System.out.println(player + " игрок возьмите от 1 до 3 спичек");
            do {
                match = Integer.valueOf(input.nextLine());
                if (match < 1 || match > 3) {
                    System.out.println("Вы ввели некорректное число спичек. Введите по новой");
                }
            } while (match < 1 || match > 3);
            matchNumbers -= match;
            System.out.println("На столе осталось: " + matchNumbers + " спичек");
                step++;
            }
        System.out.println("Победил " + player + " игрок");
        System.out.println("Игра окончена");
        }
    }


