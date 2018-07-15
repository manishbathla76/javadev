package com.moneymachine.digitalcurrency.gateway.common;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;

import com.moneymachine.digitalcurrency.gateway.bittrex.quotes.BittrexRestUtil;
import com.moneymachine.digitalcurrency.gateway.krakenadapter.quotes.KrakenRestUtil;

public class RestPoller {
	/**
	 * Seperate Thread to pull the prices in json string from a rest service and its in a queue
	 * BlockingQueue<HashMap<String,String>> queue ==> key is to identify the value in-case resttask is making multiple requests
	 * e.g. LTC_USD can be key and json string result can be the value
	 *   
	 * */
	private BlockingQueue<HashMap<String,String>> queue;
		private int startafterinmillis;
		private int repeateverymillis;
		private RestDataTask restTask;
		
		public RestPoller(BlockingQueue<HashMap<String,String>> queue, int startafterinmillis, int repeateverymillis, RestDataTask restTask){
			this.queue=queue;
			this.startafterinmillis=startafterinmillis;
			this.repeateverymillis=repeateverymillis;
			this.restTask = restTask;
		}
	   
	   public void start() {
	       Timer timer = new Timer();
	       timer.schedule(new GetExternalPriceTask(queue,restTask), startafterinmillis,repeateverymillis);   
	  }
	   
	
	

class GetExternalPriceTask extends TimerTask {
	
	private BlockingQueue<HashMap<String,String>> queue;
	private RestDataTask restTask;
	
	GetExternalPriceTask(BlockingQueue<HashMap<String,String>> queue,RestDataTask restTask){
		this.queue=queue;
		this.restTask = restTask;
	}
	
    public void run() {
    	try {
			queue.put(restTask.pullRestData());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
	
}
