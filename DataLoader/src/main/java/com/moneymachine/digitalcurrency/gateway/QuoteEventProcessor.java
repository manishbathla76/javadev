package com.moneymachine.digitalcurrency.gateway;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.moneymachine.digitalcurrency.gateway.arb.BestQuoteHandler;

public class QuoteEventProcessor extends Thread{
	
	private static QuoteEventProcessor _instance = new QuoteEventProcessor();
	LatestQuoteEventHandler latestQuoteEventHandler = new LatestQuoteEventHandler();
	BestQuoteHandler bestQuoteHandler = new BestQuoteHandler();
	
	private BlockingQueue<QuoteEvent> queue = new ArrayBlockingQueue<QuoteEvent>(200);
	
	private QuoteEventProcessor(){
		this.setName("QuoteEventProcessorThread");
		this.start();
	}

	public static QuoteEventProcessor getInstance(){
		return _instance;
	}
	
	public synchronized void processEvent(QuoteEvent event){
		queue.add(event);
	}
	
	
	public void run(){
		while(true){
			try {
					QuoteEvent event = queue.take();
					latestQuoteEventHandler.handleEvent(event);
					bestQuoteHandler.handleEvent(event);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	
	
	
	
}
