package com.moneymachine.digitalcurrency.gateway.common;

public class DataUtil {
	public static double processDouble(String value){
		double result = 0.0;
		if(value ==null || value.trim().isEmpty()){
			return result;
		}
		value = value.trim();
		result = Double.parseDouble(value);
		return result;
	}
}
