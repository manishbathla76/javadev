package com.moneymachine.digitalcurrency.gateway.gdaxadapter.position;

public class Position {
	    private String complement;

	    private String type;

	    private String max_size;

	    private String size;

	    public String getComplement ()
	    {
	        return complement;
	    }

	    public void setComplement (String complement)
	    {
	        this.complement = complement;
	    }

	    public String getType ()
	    {
	        return type;
	    }

	    public void setType (String type)
	    {
	        this.type = type;
	    }

	    public String getMax_size ()
	    {
	        return max_size;
	    }

	    public void setMax_size (String max_size)
	    {
	        this.max_size = max_size;
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
	        return "ClassPojo [complement = "+complement+", type = "+type+", max_size = "+max_size+", size = "+size+"]";
	    }
	}

