package com.moneymachine.digitalcurrency.gateway;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.moneymachine.digitalcurrency.gateway.common.Log;

public class LatestQuoteCache {
	
	private static int COUNT_FOR_STALE_QUOTE = 50;
	private static LatestQuoteCache _instance = new LatestQuoteCache();
	private Object lock = new Object();
	private ConcurrentHashMap<String, LatestQuote> _cache = new ConcurrentHashMap<String, LatestQuote>();
	private ConcurrentHashMap<String, Integer> staleQuoteCheckCounter = new ConcurrentHashMap<String, Integer>();
	
	
	private LatestQuoteCache(){
	}
	
	
	public static LatestQuoteCache getInstance(){
		return _instance;
	}
	
	public synchronized void addOrUpdate(LatestQuote quote){
		LatestQuote prevQ =  _cache.get(quote.getKey());
		_cache.put(quote.getKey(), quote);
		
		if(prevQ!=null){
			Integer counter = staleQuoteCheckCounter.get(quote.getKey());
			if(counter==null){
				//initialize for new key
				staleQuoteCheckCounter.put(quote.getKey(), new Integer(0));
			}else{
				//increment counter if Latest Quote and Previous Quotes are same
				if(prevQ.isSameQuoteValues(quote)){
						int newCount = counter.intValue() + 1;
						staleQuoteCheckCounter.put(quote.getKey(), new Integer(newCount));
						Log.log("STALE QUOTE===>" + quote.getKey() + " repeated " + newCount + " times");
						
						if(newCount >= COUNT_FOR_STALE_QUOTE){
							Log.log("****something wrong" + quote.getKey() + " repeated " + newCount + " times");
						}
						
				}else{
					//reset the counter
					staleQuoteCheckCounter.put(quote.getKey(), new Integer(0));
					
				}
				
				
			}
		}
		Log.log("LatestQuoteCache==> stored" + quote.toString());
	}
	
	public synchronized ArrayList<LatestQuote> getAllQuotesForInstrument(String instrument){
		ArrayList<LatestQuote> quotes = new ArrayList<LatestQuote>();
		_cache.values().stream().filter(q -> q.getInstrument().equalsIgnoreCase(instrument)).forEach(s -> quotes.add(s));
		return quotes;
	}	
	
	
	public synchronized ArrayList<LatestQuote> getAllQuotes(){
		ArrayList<LatestQuote> quotes = new ArrayList<LatestQuote>();
		_cache.values().forEach(q -> quotes.add(q));
		return quotes;
	}	
	
	public String toString(){
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("****CACHE STATE***** \n");
		
			for(Entry<String, LatestQuote> me: _cache.entrySet()){
				strbuf.append(me.getKey() + " " );
				strbuf.append(me.getValue().getBid() + ":" );
				strbuf.append(me.getValue().getBidSize() + "/" );
				strbuf.append(me.getValue().getAsk() + ":" );
				strbuf.append(me.getValue().getAskSize() + "\n\n" );
			}
		return strbuf.toString();
	}
	
	
	
}
