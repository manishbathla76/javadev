package com.moneymachine.digitalcurrency.gateway;

import java.time.Instant;

import com.moneymachine.digitalcurrency.gateway.common.DateUtil;

public class Quote {
	
	private final String instrument;
	private final String market;
	
	private final double bid;
	private final double bidSize;
	
	private final double ask;
	private final double askSize;
	
	private final double mid;
	private final double midSize;
	
	private final long timestamp;
	//private final String timestampstr;
	
	
	public Quote(final String instrument,
			final String market,
			final double bid,
			final double bidSize,
			final double ask,
			final double askSize,
			final double mid,
			final double midSize
			){
			this.instrument=instrument;
			this.market=market;
			this.bid=bid;
			this.bidSize=bidSize;
			this.ask=ask;
			this.askSize=askSize;
			this.mid=mid;
			this.midSize=midSize;
			timestamp = Instant.now().toEpochMilli();
			System.out.println(getTimeStampString());
			//timestampstr = 
	}


	public String getInstrument() {
		return instrument;
	}


	public String getMarket() {
		return market;
	}


	public double getBid() {
		return bid;
	}


	public double getBidSize() {
		return bidSize;
	}


	public double getAsk() {
		return ask;
	}


	public double getAskSize() {
		return askSize;
	}


	public double getMid() {
		return mid;
	}


	public double getMidSize() {
		return midSize;
	}


	public long getTimestamp() {
		return timestamp;
	}
	
	
	public String getTimeStampString(){
		return DateUtil.getReadableDateTime(timestamp);
	}
	
	public boolean isSameQuoteValues(Quote p){
		return market ==  p.market 
				&& bid == p.bid
				&& bidSize ==p.bidSize
				&& ask == p.ask
				&& askSize == p.askSize;
	}
	
	
	public String toString(){
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("instrument="+instrument+",");
		strbuf.append("market="+market+",");
		strbuf.append("bid="+bid+",");
		strbuf.append("bidSize="+bidSize+",");
		strbuf.append("ask="+ask+",");
		strbuf.append("askSize="+askSize+",");
		strbuf.append("mid="+mid+",");
		strbuf.append("midSize="+midSize+",");
		strbuf.append("timestamp="+timestamp+",");
		strbuf.append("timestampstr="+getTimeStampString()+"\n");
		return strbuf.toString();
	}
	
	
}
