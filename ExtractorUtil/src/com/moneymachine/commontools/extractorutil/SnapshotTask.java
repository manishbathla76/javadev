package com.moneymachine.commontools.extractorutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class SnapshotTask extends TimerTask {
	private final String url;
	private final String storageDir;
	private final String fileNamePrefix;
	private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public SnapshotTask(String url, String dir, String fileNamePrefix){
		this.url = url;
		this.storageDir=dir;
		this.fileNamePrefix=fileNamePrefix;
		
		//check if destination folder is there is not..create it if not there
		File dirF = new File(storageDir);
		if(!dirF.exists() || !dirF.isDirectory()){
			if(dirF.mkdir()){
				Log.log("Destination folder is created successfully");
			}else{
				Log.log("Destination folder is NOT created successfully");
			}
		}
		
	}
	
	
	public void run() {
		try{
		String content = RestUtil.getHTTPResponse(url);
		saveFile(content);
		}catch(IOException ioException){
			
		}
    }
	
	private void saveFile(String text) throws IOException{
		 File file = new File (getFileName());
		  BufferedWriter out = new BufferedWriter(new FileWriter(file)); 
		  out.write(text);
		  out.close();
	}
	
	private String getFileName(){
		    Date now = new Date();
		    String strDate = sdfDate.format(now);
		    return storageDir + "//" + fileNamePrefix + "." + strDate;
	}
	
}
