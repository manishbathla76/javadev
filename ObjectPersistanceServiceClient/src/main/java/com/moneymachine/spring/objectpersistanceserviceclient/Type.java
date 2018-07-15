package com.moneymachine.spring.objectpersistanceserviceclient;

public enum Type {
	
	TYPE ("TYPE1");
	private String stringName;
	
	Type(String s){
		this.stringName = s;
	}
	
	public String getStringName(){
		return this.stringName;
	}
	
}
