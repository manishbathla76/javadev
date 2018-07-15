package com.moneymachine.spring.objectpersistanceserviceclient;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessagePublisherTest {
	
	public void init(){
		Session session = null;
		Connection con =null;
		try{
		ActiveMQConnectionFactory factory = new 
				ActiveMQConnectionFactory("tcp://localhost:61616");
		con = factory.createConnection();
		con.start();
		Log.log("producer established connection with Active MQ");
		
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Log.log("producer created session with Active MQ");
		
		Queue queue = session.createQueue("persistobjectq");
		
		MessageProducer producer = session.createProducer(queue);
		
		Message message = session.createTextMessage("Hello World Message");
		
		producer.send(message);
		
		Log.log("producer send message to testqueue1");
		
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
