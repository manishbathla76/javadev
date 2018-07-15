package com.moneymachine.spring.objectpersistanceserviceclient;

public enum DataSourceType {
	
	YAHOO ("YAHOO"),
	MSN ("MSN");
	private String stringName;
	
	DataSourceType(String s){
		this.stringName = s;
	}
	
	public String getStringName(){
		return this.stringName;
	}
		
}
