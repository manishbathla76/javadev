package com.moneymachine.digitalcurrency.gateway.bittrex.quotes;

public class BittrexOrderBookPojo {
	private String message;

    private Result result;

    private String success;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public Result getResult ()
    {
        return result;
    }

    public void setResult (Result result)
    {
        this.result = result;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", result = "+result+", success = "+success+"]";
    }
}

 class Result
{
    private Order[] sell;

    private Order[] buy;

    public Order[] getSell ()
    {
        return sell;
    }

    public void setSell (Order[] sell)
    {
        this.sell = sell;
    }

    public Order[] getBuy ()
    {
        return buy;
    }

    public void setBuy (Order[] buy)
    {
        this.buy = buy;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sell = "+sell+", buy = "+buy+"]";
    }
}


class Order
{
    private String Quantity;

    private String Rate;

    public String getQuantity ()
    {
        return Quantity;
    }

    public void setQuantity (String Quantity)
    {
        this.Quantity = Quantity;
    }

    public String getRate ()
    {
        return Rate;
    }

    public void setRate (String Rate)
    {
        this.Rate = Rate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Quantity = "+Quantity+", Rate = "+Rate+"]";
    }
}

