package com.moneymachine.spring.objectpersistanceservice;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moneymachine.spring.objectpersistanceservice.PersistenceRequest;
import com.moneymachine.spring.objectpersistanceservice.mangodb.MongoDBAdapter;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestMongoDB  extends TestCase{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestMongoDB( String testName )
    {
        super( testName );
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		MongoDBAdapter mongoDBAdater = (MongoDBAdapter) context.getBean("MongoDBAdapter");
		PersistenceRequest perRequest = createDummyPersistenceRequest();
		mongoDBAdater.persist(perRequest);
    }
    
    
    public PersistenceRequest createDummyPersistenceRequest(){
    	String model="JSON";
    	String type="TEST";
    	String id="TEST_ID2";  
    	String metaData = "{'name': 'Manish Kumar'}";
    	String jsonString =  "{'_id':'TEST_ID2', 'name':'Manish Bathla', 'email':'manish.bathla@gmail.com'}";
    	PersistenceRequest request = new PersistenceRequest(model,type,id,metaData,jsonString);
    	return request;
    }
    
    
    
    
}
