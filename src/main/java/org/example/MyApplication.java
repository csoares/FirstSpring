package org.example;
public class MyApplication {
    private MessageService messageService;

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage() {
        System.out.println(messageService.getMessage());
    }
}
