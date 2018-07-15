package com.moneymachine.spring.objectpersistanceserviceclient;

public class InvalidDataException extends Exception {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public InvalidDataException(String message, Exception e){
			super(message,e);
		}
	
}
