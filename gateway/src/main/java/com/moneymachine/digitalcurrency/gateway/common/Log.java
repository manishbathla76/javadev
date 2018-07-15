package com.moneymachine.digitalcurrency.gateway.common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {
	
	static final Logger logger = LogManager.getLogger(Log.class.getName());
	
	public static void log(String s){
		System.out.println(s);
		logger.info(s);
		
	}
}
