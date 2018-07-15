package com.moneymachine.digitalcurrency.gateway.krakenadapter.quotes;

import com.moneymachine.digitalcurrency.gateway.common.QuoteEventPublisher;
import com.moneymachine.digitalcurrency.gateway.common.RestPoller;
import com.moneymachine.digitalcurrency.gateway.gdaxadapter.quotes.GDAXRestDataTask;

public class KrakenQuoteReader {
	
	private static final int delayInMilliSeconds = 10000; 
	
	public void init(){
		//start a thread for event publisher. specify how to transform input object
		QuoteEventPublisher eventPublisher = new QuoteEventPublisher("kraken", new TransformKrakenQuote());
		eventPublisher.start();
		
		//start rest timer/poller. specify input queue and how to get the rest data
		RestPoller restPoller = new RestPoller(eventPublisher.getInputQueue(),delayInMilliSeconds,delayInMilliSeconds,new KrakenDataTask());
		restPoller.start();
		}
		
	
}
