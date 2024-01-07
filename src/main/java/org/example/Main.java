package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyApplication app = (MyApplication) context.getBean("myApplication");
        app.processMessage();

        app.setMessageService(new SMSService());
        app.processMessage();
    }
}
