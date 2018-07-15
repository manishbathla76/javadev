package com.moneymachine.digitalcurrency.gateway.common;

import java.util.ArrayList;
import java.util.HashMap;

import com.moneymachine.digitalcurrency.gateway.Quote;

public interface TransformTask {
	
	public ArrayList<Quote> transform(HashMap<String,String> marketQuotes);
}
