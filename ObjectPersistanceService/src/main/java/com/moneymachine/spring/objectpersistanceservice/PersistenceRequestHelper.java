package com.moneymachine.spring.objectpersistanceservice;

import java.util.ArrayList;

import com.moneymachine.spring.objectpersistanceserviceclient.JSONMessage;
import com.moneymachine.spring.objectpersistanceserviceclient.ObjectMessageContent;

public class PersistenceRequestHelper {
	private JSONMessage jsonMessage;
	
	public PersistenceRequestHelper(JSONMessage jsonMessage){
		this.jsonMessage=jsonMessage;
	}
	
	public ArrayList<PersistenceRequest> getPersistenceRequests(){
		ArrayList<PersistenceRequest> requestList = new ArrayList<PersistenceRequest>();
		for(ObjectMessageContent msgContent: jsonMessage.getCONTENT_LIST()){
			PersistenceRequest request = new PersistenceRequest(jsonMessage.getMESSAGE_FORMAT_TYPE()
						,jsonMessage.getENITY(),msgContent.getID(),msgContent.getMETA_DATA(),msgContent.getCONTENT());
			requestList.add(request);
		}
		
		return requestList;
		
	}
	
}
