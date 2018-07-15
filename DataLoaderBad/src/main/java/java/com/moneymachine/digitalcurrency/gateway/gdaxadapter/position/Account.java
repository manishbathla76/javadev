package com.moneymachine.digitalcurrency.gateway.gdaxadapter.position;

public class Account {
	 private String id;

	    private String balance;

	    private String hold;

	    private String default_amount;

	    private String funded_amount;

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getBalance ()
	    {
	        return balance;
	    }

	    public void setBalance (String balance)
	    {
	        this.balance = balance;
	    }

	    public String getHold ()
	    {
	        return hold;
	    }

	    public void setHold (String hold)
	    {
	        this.hold = hold;
	    }

	    public String getDefault_amount ()
	    {
	        return default_amount;
	    }

	    public void setDefault_amount (String default_amount)
	    {
	        this.default_amount = default_amount;
	    }

	    public String getFunded_amount ()
	    {
	        return funded_amount;
	    }

	    public void setFunded_amount (String funded_amount)
	    {
	        this.funded_amount = funded_amount;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [id = "+id+", balance = "+balance+", hold = "+hold+", default_amount = "+default_amount+", funded_amount = "+funded_amount+"]";
	    }
}
