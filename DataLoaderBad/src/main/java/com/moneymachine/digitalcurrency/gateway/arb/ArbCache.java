package com.moneymachine.digitalcurrency.gateway.arb;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.moneymachine.digitalcurrency.gateway.LatestQuote;
import com.moneymachine.digitalcurrency.gateway.LatestQuoteCache;
import com.moneymachine.digitalcurrency.gateway.Quote;
import com.moneymachine.spring.objectpersistanceserviceclient.Log;

public class ArbCache {
	private static ArbCache _instance = new ArbCache();
	private Object lock = new Object();
	private ConcurrentHashMap<String, BestQuote> _cache = new ConcurrentHashMap<String, BestQuote>();
	private ArbEventHandler arbEventHandler = new ArbEventHandler();
	
	private ArbCache(){
	}
	
	
	public static ArbCache getInstance(){
		return _instance;
	}
	
	public synchronized void processQuote(LatestQuote quote){
			//remove existing values
			_cache.remove(quote.getInstrument());
			
			//recalculate best values again
			ArrayList<LatestQuote> latestQuotesForInstrument = LatestQuoteCache.getInstance().getAllQuotesForInstrument(quote.getInstrument());
			for(LatestQuote lq: latestQuotesForInstrument){
				reprocess(lq);
			}
		
		arbEventHandler.processEvent(new ArbUpdatedEvent());
	}
	private synchronized void reprocess(LatestQuote quote){
		
		BestQuote bestQuote = _cache.get(quote.getInstrument());
		if(bestQuote==null){
				//store this quote as best store
			bestQuote  =  new BestQuote(quote.getInstrument(),
					quote.getMarket(),
					quote.getBid(),
					quote.getBidSize(),
					quote.getTimestamp(),
					quote.getMarket(),
					quote.getAsk(),
					quote.getAskSize(),
					quote.getTimestamp()
					);
		}else{
			//compare bid and ask to find if we need to update
			boolean newBidBetter=false;
			boolean newAskBetter=false;
			String bidMarket;
			double bid;
			double bidSize;
			long bidTimestamp;
			String askMarket;
			double ask;
			double askSize;
			long askTimestamp;
			
			if (quote.getBid() > bestQuote.getBid()){
				newBidBetter = true;
			}
			
			if (quote.getAsk() < bestQuote.getAsk()){
				newAskBetter = true;	
			}
			
			if(newBidBetter || newAskBetter){
				if(newBidBetter){
					bidMarket = quote.getMarket();
					bid = quote.getBid();
					bidSize = quote.getBidSize();
					bidTimestamp=quote.getTimestamp();
				}else{
					bidMarket = bestQuote.getBidMarket();
					bid = bestQuote.getBid();
					bidSize = bestQuote.getBidSize();
					bidTimestamp=bestQuote.getBidTimestamp();
				}
				
				if(newAskBetter){
					askMarket = quote.getMarket();
					ask = quote.getAsk();
					askSize = quote.getAskSize();
					askTimestamp=quote.getTimestamp();
				}else{
					askMarket = bestQuote.getAskMarket();
					ask = bestQuote.getAsk();
					askSize = bestQuote.getAskSize();
					askTimestamp=bestQuote.getAskTimestamp();
				}
				
				bestQuote = new BestQuote(quote.getInstrument(),
						bidMarket,
						bid,
						bidSize,
						bidTimestamp,
						askMarket,
						ask,
						askSize,
						askTimestamp
						);
			}
			
		}
		_cache.put(bestQuote.getInstrument(), bestQuote);
		Log.log("ArbCache==> stored" + bestQuote.toString());
	}
	
	
	
	public synchronized ArrayList<BestQuote> getAllQuotes(){
		ArrayList<BestQuote> quotes = new ArrayList<BestQuote>();
		_cache.values().forEach(q -> quotes.add(q));
		return quotes;
	}	
	
	public String toString(){
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("****ARB CACHE STATE***** \n");
		
			for(Entry<String, BestQuote> me: _cache.entrySet()){
				strbuf.append(me.getKey() + " " );
				strbuf.append(me.getValue().getBidMarket() + ":" );
				strbuf.append(me.getValue().getBid() + ":" );
				strbuf.append(me.getValue().getBidSize() + "/" );
				strbuf.append(me.getValue().getAskMarket() + ":" );
				strbuf.append(me.getValue().getAsk() + ":" );
				strbuf.append(me.getValue().getAskSize() + "\n\n" );
			}
		return strbuf.toString();
	}
}

