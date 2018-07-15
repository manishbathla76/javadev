package com.moneymachine.digitalcurrency.gateway.gdaxadapter.position;

public class Margin_call
{
    private String funds;

    private String price;

    private String side;

    private String active;

    private String size;

    public String getFunds ()
    {
        return funds;
    }

    public void setFunds (String funds)
    {
        this.funds = funds;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getSide ()
    {
        return side;
    }

    public void setSide (String side)
    {
        this.side = side;
    }

    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [funds = "+funds+", price = "+price+", side = "+side+", active = "+active+", size = "+size+"]";
    }
}
