package com.moneymachine.digitalcurrency.gateway.poloniex.quotes;

import java.util.HashMap;

import com.moneymachine.digitalcurrency.gateway.common.RestDataTask;

public class PoloniexRestDataTask implements RestDataTask{
	public HashMap<String,String> pullRestData(){
		return PoloniexRestUtil.getQuotes();
}
}
