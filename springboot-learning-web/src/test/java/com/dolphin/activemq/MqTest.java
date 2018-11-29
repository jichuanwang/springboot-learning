package com.dolphin.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author jichuan.wang
 * @since 2018/11/28 16:30
 * <p>
 * </p>
 */
public class MqTest {

    @Test
    public void sendMsg() throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        MessageProducer producer = session.createProducer(session.createQueue("my-test"));
        Message message = session.createTextMessage("hello world!!!");
        producer.send(message);
        producer.close();
        session.close();
        connection.close();

    }
}
