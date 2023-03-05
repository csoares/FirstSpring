package org.example;

public class SMSService implements MessageService{
    @Override
    public String getMessage() {
        return "Hello, this is an SMS message.";
    }
}
