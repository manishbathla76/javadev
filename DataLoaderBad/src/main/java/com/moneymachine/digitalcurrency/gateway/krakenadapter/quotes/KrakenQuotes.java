package com.moneymachine.digitalcurrency.gateway.krakenadapter.quotes;

import java.util.HashMap;

public class KrakenQuotes {
	
	private HashMap<String, Result> result;

    private String[] error;

    public HashMap<String, Result> getResult ()
    {
        return result;
    }

    public void setResult (HashMap<String, Result> result)
    {
        this.result = result;
    }

    public String[] getError ()
    {
        return error;
    }

    public void setError (String[] error)
    {
        this.error = error;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+", error = "+error+"]";
    }
	
	
	class Result{
		private String[]  v;

	    private String[]  t;

	    private String[]  b;

	    private String[]  c;

	    private String[]  p;

	    private String[]  a;

	    private String  o;

	    private String[]  l;

	    private String[]  h;

	    public String[]  getV ()
	    {
	        return v;
	    }

	    public void setV (String[] v)
	    {
	        this.v = v;
	    }

	    public String[]  getT ()
	    {
	        return t;
	    }

	    public void setT (String[] t)
	    {
	        this.t = t;
	    }

	    public String[]  getB ()
	    {
	        return b;
	    }

	    public void setB (String[] b)
	    {
	        this.b = b;
	    }

	    public String[]  getC ()
	    {
	        return c;
	    }

	    public void setC (String[] c)
	    {
	        this.c = c;
	    }

	    public String[]  getP ()
	    {
	        return p;
	    }

	    public void setP (String[] p)
	    {
	        this.p = p;
	    }

	    public String[]  getA ()
	    {
	        return a;
	    }

	    public void setA (String[] a)
	    {
	        this.a = a;
	    }

	    public String  getO ()
	    {
	        return o;
	    }

	    public void setO (String o)
	    {
	        this.o = o;
	    }

	    public String[]  getL ()
	    {
	        return l;
	    }

	    public void setL (String[] l)
	    {
	        this.l = l;
	    }

	    public String[]  getH ()
	    {
	        return h;
	    }

	    public void setH (String[] h)
	    {
	        this.h = h;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [v = "+v+", t = "+t+", b = "+b+", c = "+c+", p = "+p+", a = "+a+", o = "+o+", l = "+l+", h = "+h+"]";
	    }
	}
    
    
	
}
