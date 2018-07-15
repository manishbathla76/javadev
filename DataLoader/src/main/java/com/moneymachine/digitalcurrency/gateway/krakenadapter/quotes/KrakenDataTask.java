package com.moneymachine.digitalcurrency.gateway.krakenadapter.quotes;

import java.util.HashMap;

import com.moneymachine.digitalcurrency.gateway.common.RestDataTask;

public class KrakenDataTask implements RestDataTask{
	public HashMap<String,String> pullRestData(){
		return KrakenRestUtil.getQuotes();
}
}
