package org.example;

public class EmailService implements MessageService{
    @Override
    public String getMessage() {
        return "Hello, this is an email message.";
    }
}
