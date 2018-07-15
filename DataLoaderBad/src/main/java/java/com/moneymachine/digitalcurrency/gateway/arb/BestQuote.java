package com.moneymachine.digitalcurrency.gateway.arb;

import java.time.Instant;

import com.moneymachine.digitalcurrency.gateway.common.DateUtil;
import com.moneymachine.spring.objectpersistanceserviceclient.AbstractJSONPersistable;
import com.moneymachine.spring.objectpersistanceserviceclient.EntityType;
import com.moneymachine.spring.objectpersistanceserviceclient.InvalidDataException;


public class BestQuote extends AbstractJSONPersistable{
	
	private String instrument;
	
	private final String bidMarket;
	private final double bid;
	private final double bidSize;
	private final long bidTimestamp;
	
	private final String askMarket;
	private final double ask;
	private final double askSize;
	private final long askTimestamp;
	
	private double spread;
	private double arbPercent;
	
	
	
	public BestQuote(final String instrument,
			final String bidMarket,
			final double bid,
			final double bidSize,
			final long bidTimestamp,
			final String askMarket,
			final double ask,
			final double askSize,
			final long askTimestamp
			){
			this.instrument=instrument;
			this.bidMarket=bidMarket;
			this.bid=bid;
			this.bidSize=bidSize;
			this.bidTimestamp=bidTimestamp;
			this.askMarket=askMarket;
			this.ask=ask;
			this.askSize=askSize;
			this.askTimestamp=askTimestamp;
			spread = this.bid-this.ask;
			arbPercent = ((bid-ask)*100)/Math.max(bid,ask);
	}


	public String getInstrument() {
		return instrument;
	}


	public String getBidMarket() {
		return bidMarket;
	}


	public double getBid() {
		return bid;
	}


	public double getBidSize() {
		return bidSize;
	}


	public long getBidTimestamp() {
		return bidTimestamp;
	}
	
	public String getBidTimeStampString(){
		return DateUtil.getReadableDateTime(bidTimestamp);
	}


	public String getAskMarket() {
		return askMarket;
	}


	public double getAsk() {
		return ask;
	}


	public double getAskSize() {
		return askSize;
	}


	public long getAskTimestamp() {
		return askTimestamp;
	}
	
	public String getAskTimeStampString(){
		return DateUtil.getReadableDateTime(askTimestamp);
	}
	


	public double getSpread() {
		return spread;
	}


	public double getArbPercent() {
		return arbPercent;
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return instrument + "." + DateUtil.getStorableDateTime(Instant.now().toEpochMilli());
	}


	@Override
	public String getMetaFields() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void validateData() throws InvalidDataException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public EntityType getEntityType() {
		// TODO Auto-generated method stub
		return EntityType.ARBOPPORTUNITY;
	}

	
	public String toString(){
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("instrument="+instrument+",");
		strbuf.append("bidMarket="+bidMarket+",");
		strbuf.append("bid="+bid+",");
		strbuf.append("bidSize="+bidSize+",");
		strbuf.append("bidTimestamp="+bidTimestamp+",");
		strbuf.append("askMarket="+askMarket+",");
		strbuf.append("ask="+ask+",");
		strbuf.append("askSize="+askSize+",");
		strbuf.append("askTimestamp="+askTimestamp+",");
		strbuf.append("spread="+spread+",");
		strbuf.append("arbPercent="+arbPercent+"\n");
		return strbuf.toString();
	}
	
	
	
}
