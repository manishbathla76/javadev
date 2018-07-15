package com.moneymachine.spring.objectpersistanceserviceclient;

public enum MessageFormatType {
	
	JSON ("JSON");
	private String stringName;
	
	MessageFormatType(String s){
		this.stringName = s;
	}
	
	public String getStringName(){
		return this.stringName;
	}
		
}
