package com.moneymachine.digitalcurrency.gateway.bittrex.quotes;

import com.moneymachine.digitalcurrency.gateway.common.QuoteEventPublisher;
import com.moneymachine.digitalcurrency.gateway.common.RestPoller;



public class BittrexQuoteReader {
	private static final int delayInMilliSeconds = 10000;
	
	public void init(){
		
		//start a thread for event publisher. specify how to transform input object
		QuoteEventPublisher eventPublisher = new QuoteEventPublisher("bittrex", new TransformBittrexQuote());
		eventPublisher.start();
		
		//start rest timer/poller. specify input queue and how to get the rest data
		RestPoller restPoller = new RestPoller(eventPublisher.getInputQueue(),delayInMilliSeconds,delayInMilliSeconds,new BittrexRestDataTask());
		restPoller.start();
	}


}