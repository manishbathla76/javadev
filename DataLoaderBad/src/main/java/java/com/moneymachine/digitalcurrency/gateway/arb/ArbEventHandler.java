package com.moneymachine.digitalcurrency.gateway.arb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.moneymachine.digitalcurrency.gateway.Main;
import com.moneymachine.spring.objectpersistanceserviceclient.InvalidDataException;
import com.moneymachine.spring.objectpersistanceserviceclient.ObjectPersistanceServiceClient;
import com.moneymachine.spring.objectpersistanceserviceclient.ObjectPersistanceServiceException;

public class ArbEventHandler {
	
	public synchronized void processEvent(ArbUpdatedEvent event){
		ArrayList<BestQuote> bestQuotes = ArbCache.getInstance().getAllQuotes();
		List<BestQuote> arbOpport = bestQuotes.stream().filter(q -> q.getArbPercent() > 0.8).collect(Collectors.toList());
				if(arbOpport!=null && arbOpport.size() > 0){
					ObjectPersistanceServiceClient persClient = (ObjectPersistanceServiceClient)Main.getApplicationContext().getBean("ObjectPersistanceServiceClient");
					//arbOpport.stream().forEach(a -> persClient.persistObject(a));
					
					for(BestQuote bq : arbOpport){
						try {
							persClient.persistObject(bq);
						} catch (InvalidDataException
								| ObjectPersistanceServiceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}
		
	}
}
