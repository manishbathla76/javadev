package com.moneymachine.spring.objectpersistanceservice.mangodb;

import com.moneymachine.spring.objectpersistanceservice.PersistenceRequest;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class MongoDBAdapter {
	
		private MongoDBClientFactory mongoDBClientFactory=null;
		
		public void init(){
		}
		
		public void destroy(){
		}
		
		
		
		
		
		public void persist(PersistenceRequest persistenceReq){
			DB db = mongoDBClientFactory.getMongoDB();
			//dbObject.append("META-DATA", persistenceReq.getMetaDataJsonString());
			Object o = com.mongodb.util.JSON.parse(persistenceReq.getJsonString());
			DBObject dbObject = (DBObject) o;
			dbObject.put("_id", persistenceReq.getId());
			
    		DBCollection  dbcollection = db.getCollection(persistenceReq.getType());
    		
    		if(dbcollection==null){
    			db.createCollection(persistenceReq.getType(),dbObject);
    		}else{
    			BasicDBObject query = new  BasicDBObject();
    			query.append("_id", persistenceReq.getId());
    			
    			WriteResult c1 = dbcollection.update(query , dbObject,true,false);
    			if(c1.isUpdateOfExisting()){
    				System.out.println("Updated successfully " + persistenceReq.getId());
    			}else{
    				System.out.println("Inserted successfully "+ persistenceReq.getId());
    			}
    		}
		}

		public void setMongoDBClientFactory(MongoDBClientFactory mongoDBClientFactory) {
			this.mongoDBClientFactory = mongoDBClientFactory;
		}
		
		
		
		
		
}
