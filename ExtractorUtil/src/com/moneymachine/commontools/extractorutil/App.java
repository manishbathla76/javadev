package com.moneymachine.commontools.extractorutil;

public class App {
	public static void main(String[] args) {
		/*long startafter = Long.parseLong(PropertyLoader.getProperty(Constants.SCHEDULER_START_AFTER_MILLS));
		long repeat = Long.parseLong(PropertyLoader.getProperty(Constants.SCHEDULER_REPREAT_TASK_MILLS));
		String destDir = PropertyLoader.getProperty(Constants.DESTINATION_DIR);
		String filePrefix = PropertyLoader.getProperty(Constants.FILENAME_PREFIX);
		String url = PropertyLoader.getProperty(Constants.URL);*/
		SnapshotScheduler scheduler = new SnapshotScheduler(Setting.SCHEDULER_START_AFTER,Setting.SCHEDULER_REPEAT,Setting.URL,Setting.DEST_DIR,Setting.FILE_PREFIX);
	}

}
