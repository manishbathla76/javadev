package com.moneymachine.spring.objectpersistanceserviceclient;

public interface Persistable {
		public String getID();
		public String getMetaFields();
		public void validateData() throws InvalidDataException;
		public MessageFormatType getMessageFormatType();
		public  EntityType getEntityType();
}
