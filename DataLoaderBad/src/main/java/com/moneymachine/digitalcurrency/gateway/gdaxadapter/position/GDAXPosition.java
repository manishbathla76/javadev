package com.moneymachine.digitalcurrency.gateway.gdaxadapter.position;

import java.util.HashMap;



public class GDAXPosition {
	private Position position;

    private String profile_id;

    private HashMap<String, Account> accounts;
    
    private Funding funding;

    private String product_id;

    private String status;

    private Margin_call margin_call;

    private String user_id;

    public Position getPosition ()
    {
        return position;
    }

    public void setPosition (Position position)
    {
        this.position = position;
    }

    public String getProfile_id ()
    {
        return profile_id;
    }

    public void setProfile_id (String profile_id)
    {
        this.profile_id = profile_id;
    }

    public HashMap<String, Account> getAccounts ()
    {
        return accounts;
    }

    public void setAccounts (HashMap<String, Account> accounts)
    {
        this.accounts = accounts;
    }

    public Funding getFunding ()
    {
        return funding;
    }

    public void setFunding (Funding funding)
    {
        this.funding = funding;
    }

    public String getProduct_id ()
    {
        return product_id;
    }

    public void setProduct_id (String product_id)
    {
        this.product_id = product_id;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Margin_call getMargin_call ()
    {
        return margin_call;
    }

    public void setMargin_call (Margin_call margin_call)
    {
        this.margin_call = margin_call;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [position = "+position+", profile_id = "+profile_id+", accounts = "+accounts+", funding = "+funding+", product_id = "+product_id+", status = "+status+", margin_call = "+margin_call+", user_id = "+user_id+"]";
    }
}
