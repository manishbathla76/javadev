package com.moneymachine.commontools.extractorutil;

public class Setting {
	public final static long SCHEDULER_START_AFTER = Long.parseLong(PropertyLoader.getProperty(Constants.SCHEDULER_START_AFTER_MILLS));
	public final static long SCHEDULER_REPEAT = Long.parseLong(PropertyLoader.getProperty(Constants.SCHEDULER_REPREAT_TASK_MILLS));
	public final static String DEST_DIR = PropertyLoader.getProperty(Constants.DESTINATION_DIR);
	public final static String FILE_PREFIX = PropertyLoader.getProperty(Constants.FILENAME_PREFIX);
	public final static String URL = PropertyLoader.getProperty(Constants.URL);
}
