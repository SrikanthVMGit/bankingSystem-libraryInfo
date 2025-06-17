package org.example;

public class FrictionBook extends Book{
    private String genre;


    public FrictionBook(String title, String author, String genre) {
        super(title, author);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
        System.out.println("Type: Fiction");
    }
}
