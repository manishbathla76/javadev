package com.moneymachine.digitalcurrency.gateway.krakenadapter.quotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.moneymachine.digitalcurrency.gateway.Quote;
import com.moneymachine.digitalcurrency.gateway.common.DataUtil;
import com.moneymachine.digitalcurrency.gateway.common.Log;
import com.moneymachine.digitalcurrency.gateway.common.TransformTask;
import com.moneymachine.digitalcurrency.gateway.krakenadapter.quotes.KrakenQuotes.Result;
/*
 * 
 * Get ticker information
URL: https://api.kraken.com/0/public/Ticker

Input:

pair = comma delimited list of asset pairs to get info on
Result: array of pair names and their ticker info

<pair_name> = pair name
a = ask array(<price>, <whole lot volume>, <lot volume>),
b = bid array(<price>, <whole lot volume>, <lot volume>),
c = last trade closed array(<price>, <lot volume>),
v = volume array(<today>, <last 24 hours>),
p = volume weighted average price array(<today>, <last 24 hours>),
t = number of trades array(<today>, <last 24 hours>),
l = low array(<today>, <last 24 hours>),
h = high array(<today>, <last 24 hours>),
o = today's opening price
 * 
 */
public class TransformKrakenQuote implements TransformTask {

	private static final HashMap<String,String> instrumentMap = new HashMap<String,String>();
	
	static{
		//{"error":[],"result":{"BCH":{"aclass":"currency","altname":"BCH","decimals":10,"display_decimals":5},"DASH":{"aclass":"currency","altname":"DASH","decimals":10,"display_decimals":5},"EOS":{"aclass":"currency","altname":"EOS","decimals":10,"display_decimals":5},"GNO":{"aclass":"currency","altname":"GNO","decimals":10,"display_decimals":5},"KFEE":{"aclass":"currency","altname":"FEE","decimals":2,"display_decimals":2},"USDT":{"aclass":"currency","altname":"USDT","decimals":8,"display_decimals":4},"XDAO":{"aclass":"currency","altname":"DAO","decimals":10,"display_decimals":3},"XETC":{"aclass":"currency","altname":"ETC","decimals":10,"display_decimals":5},"XETH":{"aclass":"currency","altname":"ETH","decimals":10,"display_decimals":5},"XICN":{"aclass":"currency","altname":"ICN","decimals":10,"display_decimals":5},"XLTC":{"aclass":"currency","altname":"LTC","decimals":10,"display_decimals":5},"XMLN":{"aclass":"currency","altname":"MLN","decimals":10,"display_decimals":5},"XNMC":{"aclass":"currency","altname":"NMC","decimals":10,"display_decimals":5},"XREP":{"aclass":"currency","altname":"REP","decimals":10,"display_decimals":5},"XXBT":{"aclass":"currency","altname":"XBT","decimals":10,"display_decimals":5},"XXDG":{"aclass":"currency","altname":"XDG","decimals":8,"display_decimals":2},"XXLM":{"aclass":"currency","altname":"XLM","decimals":8,"display_decimals":5},"XXMR":{"aclass":"currency","altname":"XMR","decimals":10,"display_decimals":5},"XXRP":{"aclass":"currency","altname":"XRP","decimals":8,"display_decimals":5},"XXVN":{"aclass":"currency","altname":"XVN","decimals":4,"display_decimals":2},"XZEC":{"aclass":"currency","altname":"ZEC","decimals":10,"display_decimals":5},"ZCAD":{"aclass":"currency","altname":"CAD","decimals":4,"display_decimals":2},"ZEUR":{"aclass":"currency","altname":"EUR","decimals":4,"display_decimals":2},"ZGBP":{"aclass":"currency","altname":"GBP","decimals":4,"display_decimals":2},"ZJPY":{"aclass":"currency","altname":"JPY","decimals":2,"display_decimals":0},"ZKRW":{"aclass":"currency","altname":"KRW","decimals":2,"display_decimals":0},"ZUSD":{"aclass":"currency","altname":"USD","decimals":4,"display_decimals":2}}}
		
		instrumentMap.put("XXBTZUSD", "BTCUSD");
		instrumentMap.put("XETHZUSD", "ETHUSD");
		instrumentMap.put("XLTCZUSD", "LTCUSD");
	}
	
	@Override
	public ArrayList<Quote> transform(HashMap<String, String> marketQuotes) {
		ArrayList<Quote> finalResult = new ArrayList<Quote>();
		
		for(Entry<String,String> e: marketQuotes.entrySet()){
			String jsonStr = e.getValue();
			Gson gson = new Gson();
			KrakenQuotes krakenquote = gson.fromJson(jsonStr, KrakenQuotes.class);
			finalResult.addAll(transform(krakenquote));
		}
		return finalResult;
	}
	
	
	public ArrayList<Quote> transform(KrakenQuotes kq){
		ArrayList<Quote> quotes = new ArrayList<Quote>();
		HashMap<String, Result> krakenQuotes = kq.getResult();
		Set<Entry<String, Result>> set = krakenQuotes.entrySet();
		for(Entry<String, Result> e: set){
			String instrument_id = e.getKey();
			String market = "kraken";
			Result result = e.getValue();
			double bid = DataUtil.processDouble(result.getB()[0]);
			double bidSize = DataUtil.processDouble(result.getB()[1]);
			double ask = DataUtil.processDouble(result.getA()[0]);
			double askSize = DataUtil.processDouble(result.getA()[1]);
			double mid = (bid + ask)/2;
			double midSize = (bidSize + askSize)/2;
			Quote q = new Quote(getMappedInstrument(instrument_id),market,bid,bidSize,ask,askSize,mid,midSize);
			Log.log("TransformKrakenQuote==>" + q.toString());
			quotes.add(q);
		}
		return quotes;
	}
	
	
	
	
	
	public String getMappedInstrument(String krakenInstrumentId){
		String val = instrumentMap.get(krakenInstrumentId);
		return val!=null ? val : krakenInstrumentId;
		
	}
	
	
	

	
	
}
