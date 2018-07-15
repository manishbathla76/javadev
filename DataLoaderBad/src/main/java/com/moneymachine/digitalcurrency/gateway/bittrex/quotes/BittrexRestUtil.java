package com.moneymachine.digitalcurrency.gateway.bittrex.quotes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.moneymachine.digitalcurrency.gateway.rest.RestUtil;

public class BittrexRestUtil {
	
	public static ArrayList<String> INSTRUMENTS;
	public static HashMap<String, URL> QUOTEURLLIST = new HashMap<String,URL>();
	    
	static{
		try {
			INSTRUMENTS = new ArrayList<String>(Arrays.asList("USDT-BTC","USDT-LTC","USDT-ETH","BTC-LTC","BTC-ETH"));
			for(String instrument : INSTRUMENTS){
				URL QUOTEURL = new URL("https://bittrex.com/api/v1.1/public/getorderbook?market=" + instrument + "&type=both");
				QUOTEURLLIST.put(instrument,QUOTEURL);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static HashMap<String,String> getQuotes(){
		HashMap<String,String> result = new HashMap<String,String>();
		for(String instrument : INSTRUMENTS){
			URL QUOTEURL = QUOTEURLLIST.get(instrument);
			try {
				result.put(instrument, RestUtil.getHTTPResponse(QUOTEURL));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}
}
