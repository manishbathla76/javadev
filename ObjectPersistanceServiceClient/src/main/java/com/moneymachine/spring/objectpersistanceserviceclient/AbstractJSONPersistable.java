package com.moneymachine.spring.objectpersistanceserviceclient;

public abstract class AbstractJSONPersistable implements Persistable{
	
	private String _id;
	public MessageFormatType getMessageFormatType(){
			return MessageFormatType.JSON;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}

}
