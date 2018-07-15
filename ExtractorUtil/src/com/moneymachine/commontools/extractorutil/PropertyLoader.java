package com.moneymachine.commontools.extractorutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertyLoader {
	private static final Properties p;
	private static final HashMap<String,String> propMap;
	//private static final 
	static{
		InputStream in = PropertyLoader.class.getResourceAsStream("/app.properties");
		p = new Properties();
		propMap = new HashMap<String,String>();
		try {
			p.load(in);
			for (String key : p.stringPropertyNames()) {
			    String value = p.getProperty(key);
			    Log.log("using property " + key + "=" + value);
			    propMap.put(key, value);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String propertyName){
			return propMap.get(propertyName);
	}
	
}
