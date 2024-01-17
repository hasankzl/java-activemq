package org.activemq.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class MessageReceiver {

    final
    JmsTemplate jmsTemplate;
    final
    MessageConverter messageConverter;

    public MessageReceiver(JmsTemplate jmsTemplate, MessageConverter messageConverter) {
        this.jmsTemplate = jmsTemplate;
        this.messageConverter = messageConverter;
    }

    public String receiveMessage() throws JMSException {
        try {
            Message message = jmsTemplate.receive();
            String response = (String) messageConverter.fromMessage(message);
            return response;
        }catch (Exception e){
            throw e;
        }
    }
}
