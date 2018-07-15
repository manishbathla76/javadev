package com.moneymachine.digitalcurrency.gateway.gdaxadapter.quotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.moneymachine.digitalcurrency.gateway.Quote;
import com.moneymachine.digitalcurrency.gateway.common.DataUtil;
import com.moneymachine.digitalcurrency.gateway.common.Log;
import com.moneymachine.digitalcurrency.gateway.common.TransformTask;

public class TransformGDAXQuote implements TransformTask {
private static final HashMap<String,String> instrumentMap = new HashMap<String,String>();
	
	static{
		instrumentMap.put("BTC-USD", "BTCUSD");
		instrumentMap.put("ETH-USD", "ETHUSD");
		instrumentMap.put("LTC-USD", "LTCUSD");
		instrumentMap.put("ETH-BTC", "ETHBTC");
		instrumentMap.put("LTC-BTC", "LTCBTC");
	}
	
	@Override
	public ArrayList<Quote> transform(HashMap<String, String> marketQuotes) {
		ArrayList<Quote> quotes = new ArrayList<Quote>();
		for(Entry<String,String> e: marketQuotes.entrySet()){
			String jsonStr = e.getValue();
			Gson gson = new Gson();
			GDAXQuote gdaxquote = gson.fromJson(jsonStr, GDAXQuote.class);
			quotes.add(transform(e.getKey(),gdaxquote));
			//publish this priceEvent to consumers
			
		}
		return quotes;
	}
	
	
	private Quote transform(String instrument_id, GDAXQuote inq){
		 String[] bidQ = inq.getBids()[0];
		 String[] askQ = inq.getAsks()[0];
		 String market = "gdax";
		
		double bid = DataUtil.processDouble(bidQ[0]);
		double bidSize = DataUtil.processDouble(bidQ[1]);
		double ask = DataUtil.processDouble(askQ[0]);
		double askSize = DataUtil.processDouble(askQ[1]);
		double mid = (bid + ask)/2;
		double midSize = (bidSize + askSize)/2;
		Quote q = new Quote(getMappedInstrument(instrument_id),market,bid,bidSize,ask,askSize,mid,midSize);
		Log.log("TransformGDAXQuote==>" + q.toString());
		return q;
	}
	
	
	public String getMappedInstrument(String instrumentId){
		String val = instrumentMap.get(instrumentId);
		return val!=null ? val : instrumentId;
		
	}
	
}
