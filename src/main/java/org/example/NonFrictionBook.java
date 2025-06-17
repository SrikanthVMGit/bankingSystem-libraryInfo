package org.example;

import javax.security.auth.Subject;

public class NonFrictionBook extends Book{
    private String subject;


    public NonFrictionBook(String title, String author, String subject) {
        super(title, author);
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Type: Non-Fiction");
    }



}
