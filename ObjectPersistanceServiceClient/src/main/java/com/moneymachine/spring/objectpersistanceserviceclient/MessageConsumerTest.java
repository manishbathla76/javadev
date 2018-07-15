package com.moneymachine.spring.objectpersistanceserviceclient;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageConsumerTest {
	
	public void init(){
		Session session = null;
		Connection con =null;
		try{
		ActiveMQConnectionFactory factory = new 
				ActiveMQConnectionFactory("tcp://localhost:61616");
		con = factory.createConnection();
		con.start();
		Log.log("consumer established connection with Active MQ");
		
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Log.log("consumer created session with Active MQ");
		
		Queue queue = session.createQueue("testqueue1");
		
		MessageConsumer consumer = session.createConsumer(queue);
		
		TextMessage message = (TextMessage)consumer.receive();
		
		Log.log("Comsumer received message from testqueue1" + message.getText());
		
		}catch(Exception e){
			Log.log("Exception" + e);
		}finally{
			try {
				session.close();
				con.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
