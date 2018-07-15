package com.moneymachine.digitalcurrency.gateway.bittrex.quotes;

import java.util.HashMap;

import com.moneymachine.digitalcurrency.gateway.common.RestDataTask;

public class BittrexRestDataTask implements RestDataTask{
	public HashMap<String,String> pullRestData(){
			return BittrexRestUtil.getQuotes();
	}
}
