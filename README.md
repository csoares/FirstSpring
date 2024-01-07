# Toy example of Spring Application

1. Create a new Maven project in your IDE, and add the following dependencies to the pom.xml file:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.0.11</version>
    </dependency>
</dependencies>
```

2. Create an interface called MessageService that defines a single method called getMessage():

```java 
public interface MessageService {
    String getMessage();
}
```

3. Create a class called EmailService that implements the MessageService interface:

```java

public class EmailService implements MessageService {
    public String getMessage() {
        return "Hello, this is an email message.";
    }
}
```

4. Create a class called SMSService that also implements the MessageService interface:
```java

public class SMSService implements MessageService {
    public String getMessage() {
        return "Hello, this is an SMS message.";
    }
}
```

5. Create a class called MyApplication that has a private MessageService instance variable, and a public set method for injecting the 
MessageService instance:

```java 
public class MyApplication {
    private MessageService messageService;
    
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
    
    public void processMessage() {
        System.out.println(messageService.getMessage());
    }
}
```

6. Create a Spring configuration file in the main ressource called applicationContext.xml, and add the following bean definitions:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
http://www.springframework.org/schema/beans/spring-beans-3.2.xsd">
       
    <bean id="emailService" class="org.example.EmailService"/>
    
    <bean id="smsService" class="org.example.SMSService"/>
    
    <bean id="myApplication" class="org.example.MyApplication">
        <property name="messageService" ref="smsService"/>
    </bean>
    
</beans>
```

This configuration file defines two beans (emailService and smsService) of type MessageService, and a third bean (myApplication) of 
type MyApplication that has the smsService instance injected into it.



7. Finally, create a Main class that loads the Spring configuration file, retrieves the myApplication bean from the Spring container, 
and invokes the processMessage() method:

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyApplication app = (MyApplication) context.getBean("myApplication");
        app.processMessage();
    }
}
```

When you run the Main class, the output should be:

```
Hello, this is an SMS message.
```

This output indicates that the MyApplication class successfully injected the SMSService instance into its messageService instance 
variable, and that the processMessage() method correctly invoked the getMessage() method of the SMSService instance.



