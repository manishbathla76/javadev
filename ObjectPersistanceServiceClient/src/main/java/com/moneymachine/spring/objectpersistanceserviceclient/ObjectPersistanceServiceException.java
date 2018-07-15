package com.moneymachine.spring.objectpersistanceserviceclient;

public class ObjectPersistanceServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public ObjectPersistanceServiceException(String message, Exception e){
			super(message,e);
		}
}
