package com.moneymachine.digitalcurrency.gateway.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private final static String READABLE_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
	private final static String STORABLE_DATETIME_FORMAT = "yyyyMMddHHmmssSSS";
	
	public static String getReadableDateTime(long epochTime){
		  Date date = new Date(epochTime);
		  DateFormat format = new SimpleDateFormat(READABLE_DATETIME_FORMAT);
		  return format.format(date);
	}
	
	public static String getStorableDateTime(long epochTime){
		  Date date = new Date(epochTime );
		  DateFormat format = new SimpleDateFormat(STORABLE_DATETIME_FORMAT);
		  return format.format(date);
	}
	
	
}
