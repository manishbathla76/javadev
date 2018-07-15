package com.moneymachine.spring.objectpersistanceserviceclient;

import com.google.gson.Gson;


public class JSONHelper {
	
		public static String toJSON(Object obj){
			Gson gson = new Gson();
			return gson.toJson(obj);
		}
		
		@SuppressWarnings("unchecked")
		public static Object fromJSON(String jsonString, Class clazz){
			Gson gson = new Gson();
			return gson.fromJson(jsonString, clazz);
		}
}
