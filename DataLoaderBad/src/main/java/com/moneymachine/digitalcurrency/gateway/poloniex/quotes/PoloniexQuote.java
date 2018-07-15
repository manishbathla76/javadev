package com.moneymachine.digitalcurrency.gateway.poloniex.quotes;

public class PoloniexQuote {
	
	private String[][] asks;

    private String seq;

    private String isFrozen;

    private String[][] bids;

    public String[][] getAsks ()
    {
        return asks;
    }

    public void setAsks (String[][] asks)
    {
        this.asks = asks;
    }

    public String getSeq ()
    {
        return seq;
    }

    public void setSeq (String seq)
    {
        this.seq = seq;
    }

    public String getIsFrozen ()
    {
        return isFrozen;
    }

    public void setIsFrozen (String isFrozen)
    {
        this.isFrozen = isFrozen;
    }

    public String[][] getBids ()
    {
        return bids;
    }

    public void setBids (String[][] bids)
    {
        this.bids = bids;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [asks = "+asks+", seq = "+seq+", isFrozen = "+isFrozen+", bids = "+bids+"]";
    }
}
