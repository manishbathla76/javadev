package com.moneymachine.digitalcurrency.gateway.krakenadapter.quotes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import com.moneymachine.digitalcurrency.gateway.rest.RestUtil;

public final class KrakenRestUtil {

	
	public final static String INSTRUMENTS = "XBTUSD,LTCUSD,ETHUSD";
	public final static String QUOTESURLSTR="https://api.kraken.com/0/public/Ticker?pair=" + INSTRUMENTS;
	public static URL QUOTEURL;
	
	static{
		try {
			QUOTEURL = new URL(QUOTESURLSTR);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static HashMap<String,String> getQuotes(){
		HashMap<String,String> result = new HashMap<String,String>();
		try {
			result.put("ALL", RestUtil.getHTTPResponse(QUOTEURL));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
}
