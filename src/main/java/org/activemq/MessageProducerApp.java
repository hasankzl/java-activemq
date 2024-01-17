package org.activemq;

import org.activemq.config.AppConfig;
import org.activemq.producer.MessageSender;
import org.activemq.receiver.MessageReceiver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = context.getBean(MessageSender.class);
        messageSender.sendMessage("Send message");

        context.close();
    }
}
