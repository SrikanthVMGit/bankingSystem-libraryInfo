package org.example;

public class Romance extends Book{
    private String type;

    public Romance(String title, String author, String type) {
        super(title, author);
        this.type = type;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Type: " + type);
        System.out.println("Type: Romance");
    }
}
