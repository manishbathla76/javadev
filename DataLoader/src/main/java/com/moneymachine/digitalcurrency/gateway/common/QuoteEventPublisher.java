package com.moneymachine.digitalcurrency.gateway.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.moneymachine.digitalcurrency.gateway.Quote;
import com.moneymachine.digitalcurrency.gateway.QuoteEvent;
import com.moneymachine.digitalcurrency.gateway.QuoteEventProcessor;

public class QuoteEventPublisher extends Thread{
	
	private BlockingQueue<HashMap<String,String>>  inputQueue = new ArrayBlockingQueue<HashMap<String,String>>(10);
	private TransformTask tranformTask;
	
	public QuoteEventPublisher(String queueName, TransformTask tranformTask){
		this.setName(queueName);
		this.tranformTask = tranformTask;
	}
	
	
	public BlockingQueue<HashMap<String,String>> getInputQueue(){
		return inputQueue;
	}
	
	public void run(){
		while(true){
			try {
				synchronized(this){
					HashMap<String,String> inputMarketQuotes = inputQueue.take();
					ArrayList<Quote> quoteList = tranformTask.transform(inputMarketQuotes);
						//publish this priceEvent to consumers
					QuoteEventProcessor.getInstance().processEvent(new QuoteEvent(quoteList));
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
