package com.moneymachine.spring.objectpersistanceserviceclient;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class JSONMessage {
		public String getMESSAGE_FORMAT_TYPE() {
		return MESSAGE_FORMAT_TYPE;
	}

	public String getENITY() {
		return ENITY;
	}


	public List<ObjectMessageContent> getCONTENT_LIST() {
		return CONTENT_LIST;
	}

		private String MESSAGE_FORMAT_TYPE;
		private String ENITY;
		private List<ObjectMessageContent> CONTENT_LIST;
		
		public JSONMessage(String msgFormatType, String entity, List<ObjectMessageContent> contentList){
				this.MESSAGE_FORMAT_TYPE=msgFormatType;
				this.ENITY=entity;
				this.CONTENT_LIST=contentList;
		}
		
		
		public JSONMessage(TextMessage textMsg){
			//hey header properties
			try {
				this.MESSAGE_FORMAT_TYPE=textMsg.getStringProperty("MESSAGE_FORMAT_TYPE");
				this.ENITY=textMsg.getStringProperty("ENITY");
				
				//get content
				this.CONTENT_LIST = new ArrayList<ObjectMessageContent>();
				String text = textMsg.getText();
				JSONMessage jsonObj = (JSONMessage) JSONHelper.fromJSON(text, JSONMessage.class);
				this.CONTENT_LIST = jsonObj.CONTENT_LIST;
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		public Message createJMSMessage(Session session) throws JMSException{
			TextMessage textMsg = session.createTextMessage();
			
			//set header
			textMsg.setStringProperty("MESSAGE_FORMAT_TYPE", MESSAGE_FORMAT_TYPE);
			textMsg.setStringProperty("ENITY", ENITY);
			
			
			
			//set content
			if(CONTENT_LIST!=null && CONTENT_LIST.size() > 0){
				StringBuffer contentBuffer = new StringBuffer();
				contentBuffer.append(JSONHelper.toJSON(this));
				textMsg.setText(contentBuffer.toString());
				/*for(ObjectMessageContent objectContent: CONTENT_LIST){
					contentBuffer.append(JSONHelper.toJSON(objectContent));
				}
				
				if(CONTENT_LIST.size()==1){
					textMsg.setText("CONTENT:" + contentBuffer.toString());
				}else{
					textMsg.setText("CONTENT_LIST:" + contentBuffer.toString());
				}*/
				
			}else{
				throw new JMSException("No Object found in the list");
			}
			
			
			return textMsg;
		}
		
		
		
		
}


