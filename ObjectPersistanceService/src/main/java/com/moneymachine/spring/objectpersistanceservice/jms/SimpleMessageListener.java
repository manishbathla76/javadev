package com.moneymachine.spring.objectpersistanceservice.jms;

import java.util.ArrayList;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.moneymachine.spring.objectpersistanceservice.Log;
import com.moneymachine.spring.objectpersistanceservice.PersistenceRequest;
import com.moneymachine.spring.objectpersistanceservice.PersistenceRequestHelper;
import com.moneymachine.spring.objectpersistanceservice.mangodb.MongoDBAdapter;
import com.moneymachine.spring.objectpersistanceserviceclient.JSONMessage;

public class SimpleMessageListener implements MessageListener,ApplicationContextAware{
		
		private ApplicationContext applicationContext;
		private long messagecounter=0;
		public SimpleMessageListener(){
			Log.log("SimpleMessageListener Object Created");
		}
		
		public void onMessage(Message message){
				messagecounter++;
				//Log.log("SimpleMessageListener onMessage");
				TextMessage textMessage = (TextMessage)message;
				persistObjects(textMessage);
		}
		
		
		
		private void persistObjects(TextMessage textMessage){
			JSONMessage jsonMsg = new JSONMessage(textMessage);
			//Send it to seperate Thread to handle this Message
			Log.log("Comsumer received message " +  messagecounter + " for entity"+ jsonMsg.getENITY());
			PersistenceRequestHelper persistenceHelper = new PersistenceRequestHelper(jsonMsg);
			ArrayList<PersistenceRequest> requests = persistenceHelper.getPersistenceRequests();
			MongoDBAdapter MongoDBAdapter = (MongoDBAdapter)this.applicationContext.getBean("MongoDBAdapter");
			for(PersistenceRequest req : requests){
				MongoDBAdapter.persist(req);
			}
			
		}
		
		
		    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		        this.applicationContext = applicationContext;
		    }
		
}
