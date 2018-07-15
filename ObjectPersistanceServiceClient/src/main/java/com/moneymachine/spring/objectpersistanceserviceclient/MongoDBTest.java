package com.moneymachine.spring.objectpersistanceserviceclient;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class MongoDBTest {
	public static void test() {
	    try {
	    		MongoClient mangoclient = new MongoClient("localhost", 27017);
	    		DB db = mangoclient.getDB( "test");
	    		String jsonString = "{'_id':'test_id1', 'name':'Manish Bathla', 'email':'manish.bathla@gmail.com'}";
	    		
	    		DBObject dbObject = (DBObject) JSON.parse(jsonString);
	    		DBCollection  testColl = db.getCollection("TestColl");
	    		
	    		if(testColl==null){
	    			db.createCollection("TestColl",dbObject);
	    		}else{
	    			String queryString = "{'_id':'test_id1'}";
	    			DBObject query = (DBObject) JSON.parse(queryString);
	    			WriteResult c1 = testColl.update(query , dbObject,true,false);
	    			if(c1.isUpdateOfExisting())
	    				System.out.println("Updated successfully");
	    			else
	    				System.out.println("Inserted successfully");
	    		}
	    		
	    		

	    }catch(Exception e){
	    	System.out.println("Exception " + e);
	    }
	}
	
	//WriteResult c1 = coll.update(query, o1, true, false);
	 
    //DBCursor carcursor = coll.find();

    //try {
      //  while (carcursor.hasNext()) {
        //    System.out.println(carcursor.next());
        //}
    ///} finally {
       // carcursor.close();
    //}

}