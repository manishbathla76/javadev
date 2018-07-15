package com.moneymachine.digitalcurrency.gateway.bittrex.quotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.moneymachine.digitalcurrency.gateway.Quote;
import com.moneymachine.digitalcurrency.gateway.QuoteEvent;
import com.moneymachine.digitalcurrency.gateway.QuoteEventProcessor;
import com.moneymachine.digitalcurrency.gateway.common.DataUtil;
import com.moneymachine.digitalcurrency.gateway.common.Log;
import com.moneymachine.digitalcurrency.gateway.common.TransformTask;


public class TransformBittrexQuote  implements TransformTask {
	
	private static final HashMap<String,String> instrumentMap = new HashMap<String,String>();
	
	static{
		instrumentMap.put("USDT-BTC", "BTCUSD");
		instrumentMap.put("USDT-ETH", "ETHUSD");
		instrumentMap.put("USDT-LTC", "LTCUSD");
		instrumentMap.put("BTC-ETH", "ETHBTC");
		instrumentMap.put("BTC-LTC", "LTCBTC");
	}
	
	
	@Override
	public ArrayList<Quote> transform(HashMap<String, String> marketQuotes) {
		ArrayList<Quote> quotes = new ArrayList<Quote>();
		for(Entry<String,String> e: marketQuotes.entrySet()){
			String jsonStr = e.getValue();
			Gson gson = new Gson();
			BittrexOrderBookPojo bitquote = gson.fromJson(jsonStr, BittrexOrderBookPojo.class);
			quotes.add(transform(e.getKey(),bitquote));
			//publish this priceEvent to consumers
			
		}
		return quotes;
	}

	
	private Quote transform(String instrument_id, BittrexOrderBookPojo bq){
		 
		 Order[] buyOrders = bq.getResult().getBuy();
		 Order[] sellOrders = bq.getResult().getSell();
		 
		 Order buyOrder = buyOrders[0];
		 Order sellOrder = sellOrders[0];
		
		String market = "bittrex";
		
		double bid = DataUtil.processDouble(buyOrder.getRate());
		double bidSize = DataUtil.processDouble(buyOrder.getQuantity());
		double ask = DataUtil.processDouble(sellOrder.getRate());
		double askSize = DataUtil.processDouble(sellOrder.getQuantity());
		double mid = (bid + ask)/2;
		double midSize = (bidSize + askSize)/2;
		Quote q = new Quote(getMappedInstrument(instrument_id),market,bid,bidSize,ask,askSize,mid,midSize);
		Log.log("TransformBittrexQuote==>" + q.toString());
		return q;
	}
	
	
	
	
	
	public String getMappedInstrument(String instrumentId){
		String val = instrumentMap.get(instrumentId);
		return val!=null ? val : instrumentId;
		
	}
	
	
}
