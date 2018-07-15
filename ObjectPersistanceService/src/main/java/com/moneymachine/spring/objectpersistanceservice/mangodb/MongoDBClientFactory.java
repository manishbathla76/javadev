package com.moneymachine.spring.objectpersistanceservice.mangodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBClientFactory {
	private String host;
	private int port;
	private String database;
	private DB db;
	private MongoClient mangoclient;
	
	public void init(){
		mangoclient = new MongoClient(host, port);
		db = mangoclient.getDB(database);
	}
	
	public DB getMongoDB(){
		//add caching options
		return db;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
	
	public void destroy(){
	}

}
