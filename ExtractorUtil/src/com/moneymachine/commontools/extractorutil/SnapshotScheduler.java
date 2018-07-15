package com.moneymachine.commontools.extractorutil;

import java.util.Timer;

public class SnapshotScheduler {
	
	public SnapshotScheduler(long startafterinmillis,  long repeateverymillis, String url, String dir, String fileNamePrefix){
		Timer timer = new Timer();
	    timer.schedule(new SnapshotTask(url,dir,fileNamePrefix), startafterinmillis,repeateverymillis);  
	}
	   
}
