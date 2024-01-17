package org.activemq;

import org.activemq.config.AppConfig;
import org.activemq.producer.MessageSender;
import org.activemq.receiver.MessageReceiver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import javax.jms.JMSException;
import javax.jms.Message;

public class MessageConsumerApp {

    public static void main(String[] args) throws JMSException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageReceiver receiver= context.getBean(MessageReceiver.class);
        String message =   receiver.receiveMessage();
        System.out.println("message : "  +message);
        context.close();
    }
}
