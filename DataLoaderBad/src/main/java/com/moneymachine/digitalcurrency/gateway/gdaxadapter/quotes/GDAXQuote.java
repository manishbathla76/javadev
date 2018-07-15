package com.moneymachine.digitalcurrency.gateway.gdaxadapter.quotes;

/*
{
    "sequence": "3",
    "bids": [
        [ price, size, num-orders ],
    ],
    "asks": [
        [ price, size, num-orders ],
    ]
}*/
public class GDAXQuote {
	
	private String[][] asks;

    private String sequence;

    private String[][] bids;

    public String[][] getAsks ()
    {
        return asks;
    }

    public void setAsks (String[][] asks)
    {
        this.asks = asks;
    }

    public String getSequence ()
    {
        return sequence;
    }

    public void setSequence (String sequence)
    {
        this.sequence = sequence;
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
        return "ClassPojo [asks = "+asks+", sequence = "+sequence+", bids = "+bids+"]";
    }
}
