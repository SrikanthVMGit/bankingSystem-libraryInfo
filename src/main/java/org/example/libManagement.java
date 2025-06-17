package org.example;

public class libManagement {

    public static void main(String[] args) {
        FrictionBook friction = new FrictionBook("The Hobbit", "J.R.R. Tolkien", "Adventure");
        NonFrictionBook nonfriction = new NonFrictionBook("Sapiens: A Brief History of Humankind", "Yuval Noah Harari",  "History");
        Romance romance = new Romance("Pride and Prejudice","Jane Austen","Love");

        System.out.println("---- Fiction Book ----");
        friction.displayInfo();

        System.out.println("\n---- Non-Fiction Book ----");
        nonfriction.displayInfo();

        System.out.println("\n---- Romance Book ----");
        romance.displayInfo();
    }
}
