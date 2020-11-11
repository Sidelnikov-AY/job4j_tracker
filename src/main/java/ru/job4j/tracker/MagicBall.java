package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

public class MagicBall {

    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        int answer = new Random().nextInt(3);
        String answerText = "";
        if (answer == 0) {
            answerText = "Да";
        } else if (answer == 1) {
            answerText = "Нет";
        } else {
            answerText = "Может быть";
        }
        System.out.println(answerText);


    }
}
