package com.moneymachine.spring.objectpersistanceserviceclient;

public enum EntityType {
	TICKERINFO ("TICKERINFO"),
	LATESTPRICE ("LATESTPRICE"),
	FXRATE ("FXRATE"),
	
	ANNINCOMESTMT ("ANNINCOMESTMT"),
	ANNBALANCESHEET ("ANNBALANCESHEET"),
	ANNCASHFLOWSTMT ("ANNCASHFLOWSTMT"),
	
	QTRINCOMESTMT ("QTRINCOMESTMT"),
	QTRBALANCESHEET ("QTRBALANCESHEET"),
	QTRCASHFLOWSTMT ("QTRCASHFLOWSTMT"),
	
	FCFERESULT ("FCFERESULT"),
	TRADE ("TRADE"),
	POSITION ("POSITION"),
	
	ARBOPPORTUNITY("ARBOPPORTUNITY");
	
	private String stringName;
	
	EntityType(String s){
		this.stringName = s;
	}
	
	public String getStringName(){
		return this.stringName;
	}
}
