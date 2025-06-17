package org.example;

public class Book {
    protected String title;
    protected String author;
    //protected is used because only the classes inherited directly will be able to access these.

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        /* These variables are not directly initialzied directly so when in main method it is initialized
        it will point to this and then to the declared one*/
    }

    public void displayInfo(){
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
    }
}
