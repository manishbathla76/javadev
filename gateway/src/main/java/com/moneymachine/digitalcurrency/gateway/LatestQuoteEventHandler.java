package com.moneymachine.digitalcurrency.gateway;

public class LatestQuoteEventHandler {
		
	public synchronized void handleEvent(QuoteEvent event){
		event.getQuotes().forEach(q -> LatestQuoteCache.getInstance().addOrUpdate(new LatestQuote(q)));
	}
	
}
