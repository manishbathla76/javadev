package com.moneymachine.digitalcurrency.gateway.arb;

import com.moneymachine.digitalcurrency.gateway.LatestQuote;
import com.moneymachine.digitalcurrency.gateway.LatestQuoteCache;
import com.moneymachine.digitalcurrency.gateway.QuoteEvent;

public class BestQuoteHandler {
	public synchronized void handleEvent(QuoteEvent event){
		event.getQuotes().forEach(q -> ArbCache.getInstance().processQuote(new LatestQuote(q)));
	}
}
