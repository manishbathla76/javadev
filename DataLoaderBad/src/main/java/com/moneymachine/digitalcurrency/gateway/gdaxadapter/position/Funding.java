package com.moneymachine.digitalcurrency.gateway.gdaxadapter.position;

public class Funding
{
    private Oldest_outstanding oldest_outstanding;

    private String funding_value;

    private String max_funding_value;

    public Oldest_outstanding getOldest_outstanding ()
    {
        return oldest_outstanding;
    }

    public void setOldest_outstanding (Oldest_outstanding oldest_outstanding)
    {
        this.oldest_outstanding = oldest_outstanding;
    }

    public String getFunding_value ()
    {
        return funding_value;
    }

    public void setFunding_value (String funding_value)
    {
        this.funding_value = funding_value;
    }

    public String getMax_funding_value ()
    {
        return max_funding_value;
    }

    public void setMax_funding_value (String max_funding_value)
    {
        this.max_funding_value = max_funding_value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [oldest_outstanding = "+oldest_outstanding+", funding_value = "+funding_value+", max_funding_value = "+max_funding_value+"]";
    }
}
			
			
