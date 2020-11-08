package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book harryPotter = new Book("Harry Potter", 666);
        Book lordOfTheRings = new Book("Lord of the rings", 777);
        Book effectiveJava = new Book("Effective JAVA", 999);
        Book cleanCode = new Book("Clean code", 464);
        Book[] bookShelf = new Book[4];
        bookShelf[0] = harryPotter;
        bookShelf[1] = lordOfTheRings;
        bookShelf[2] = effectiveJava;
        bookShelf[3] = cleanCode;
        for (Book b : bookShelf) {
            System.out.println(b.getBookName() + " - " + b.getNumberOfPages());
        }

        Book temp = bookShelf[0];
        bookShelf[0] = bookShelf[3];
        bookShelf[3] = temp;
        System.out.println();
        for (Book b : bookShelf) {
            System.out.println(b.getBookName() + " - " + b.getNumberOfPages());
        }

        System.out.println();
        for (Book b : bookShelf) {
            if (b.getBookName().equals("Clean code")) {
                System.out.println(b.getBookName() + " - " + b.getNumberOfPages());
            }
        }

    }
}
