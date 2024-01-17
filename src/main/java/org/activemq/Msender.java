package org.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Msender {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queueName= "MESSAGE_QUEUE";
    public static void main( String[] args ) throws JMSException {

        System.out.println("url :"+ url + " queue name : " + queueName);

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(queueName);

        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("hi, how are you");

        producer.send(message);
        System.out.println("message " + message.getText() + "send successfully");
        connection.close();
    }
}
