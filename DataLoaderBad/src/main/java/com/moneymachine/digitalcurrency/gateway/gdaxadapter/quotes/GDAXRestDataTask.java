package com.moneymachine.digitalcurrency.gateway.gdaxadapter.quotes;

import java.util.HashMap;

import com.moneymachine.digitalcurrency.gateway.common.RestDataTask;

public class GDAXRestDataTask implements RestDataTask{
	public HashMap<String,String> pullRestData(){
		return GDAXRestUtil.getQuotes();
}
}
