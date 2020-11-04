package oop;

public class Student {

    public void music(String lyrics) {
        System.out.println("I can sign a song: " + lyrics);
    }

    public void song() {
        System.out.println("I belive I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        String song = "I believe, I can fly";
        petya.music(song);
        petya.music(song);
        petya.music(song);
        petya.song();
        petya.song();
        petya.song();
    }
}
