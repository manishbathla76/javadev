package com.moneymachine.spring.objectpersistanceserviceclient;

public class ObjectMessageContent{
	String ID;
	String META_DATA;
	String CONTENT;
	
	public ObjectMessageContent(String id, String metaData,String content){
		this.ID = id;
		this.META_DATA=metaData;
		this.CONTENT=content;
	}

	public String getID() {
		return ID;
	}

	public String getMETA_DATA() {
		return META_DATA;
	}

	public String getCONTENT() {
		return CONTENT;
	}
	
	
	
}
