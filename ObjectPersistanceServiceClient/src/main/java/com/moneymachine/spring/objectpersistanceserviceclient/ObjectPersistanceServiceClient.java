package com.moneymachine.spring.objectpersistanceserviceclient;

import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ObjectPersistanceServiceClient {
		
		private ActiveMQConnectionFactory factory;
		private Session session = null;
		private Connection con =null;
		private Queue queue;
		private MessageProducer producer;
		
		public void persistObject(Persistable object) throws InvalidDataException,ObjectPersistanceServiceException{
			String id = object.getID();
			String metaDataFields = object.getMetaFields();
			String JsonString = JSONHelper.toJSON(object);
			
			ObjectMessageContent messageContent = new ObjectMessageContent(id,"META=META1", JsonString);
			ArrayList<ObjectMessageContent> contList = new ArrayList<ObjectMessageContent>();
			contList.add(messageContent);
			JSONMessage jsonMsg = new JSONMessage(object.getMessageFormatType().getStringName(),object.getEntityType().getStringName(),contList);
			Message message;
			try {
				message = jsonMsg.createJMSMessage(session);
				producer.send(message);
				Log.log("producer send message to persistobjectq");	
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public void init(){
			
			try{
			 factory = new 
					ActiveMQConnectionFactory("tcp://localhost:61616");
			con = factory.createConnection();
			con.start();
			Log.log("producer established connection with Active MQ");
			
			session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Log.log("producer created session with Active MQ");
			
			queue = session.createQueue("persistobjectq");
			
			producer = session.createProducer(queue);
			
			}catch(Exception e){
				Log.log("Exception" + e);
			}
			
		}
		
		
		public void destroy(){
			if(producer!=null){
				try {
					producer.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(session!=null){
				try {
					session.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con!=null){
				try {
					con.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
}
