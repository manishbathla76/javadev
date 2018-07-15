package com.moneymachine.digitalcurrency.gateway;

import java.util.ArrayList;

public class QuoteEvent {
	
	private ArrayList<Quote> quotes;
	
	public QuoteEvent(ArrayList<Quote> quotes){
		this.quotes = quotes;
	}
	
	public ArrayList<Quote> getQuotes(){
		return this.quotes;
	}
}
