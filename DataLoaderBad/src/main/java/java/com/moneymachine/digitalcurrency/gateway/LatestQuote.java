package com.moneymachine.digitalcurrency.gateway;

import java.time.Instant;

public class LatestQuote extends Quote{
	
	public LatestQuote(final String instrument,
			final String market,
			final double bid,
			final double bidSize,
			final double ask,
			final double askSize,
			final double mid,
			final double midSize
			){
			super(
			instrument,
			market,
			bid,
			bidSize,
			ask,
			askSize,
			mid,
			midSize);
	}
	
	public LatestQuote(Quote quote){
		super(
				quote.getInstrument(),
				quote.getMarket(),
				quote.getBid(),
				quote.getBidSize(),
				quote.getAsk(),
				quote.getAskSize(),
				quote.getMid(),
				quote.getMidSize());
	}
	
	
	public String getKey(){
		return this.getInstrument() + "." + this.getMarket();
	}
}
