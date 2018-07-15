package com.moneymachine.spring.objectpersistanceservice;

public class PersistenceRequest {
	private final String model;
	private final String type;
	private final String id;
	private final String metaDataJsonString;
	private final String jsonString;
	
	
	public PersistenceRequest(String model, String type, String id, String metaData, String jsonString){
		this.model=model;
		this.type=type;
		this.id=id;
		this.metaDataJsonString=metaData;
		this.jsonString=jsonString;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public String getMetaDataJsonString() {
		return metaDataJsonString;
	}

	public String getJsonString() {
		return jsonString;
	}
	
	
	
	
	
}
