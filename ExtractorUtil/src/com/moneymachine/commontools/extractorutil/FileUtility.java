package com.moneymachine.commontools.extractorutil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtility {
	
		public static File[] getFiles(){
			File folder = new File(Setting.DEST_DIR);
			File[] files = folder.listFiles();
			return files;
		}
		
		public static List<String> getFileNames(){
			File[] files = getFiles();
			List<File> fileList = Arrays.asList(files);
			List<String> names = fileList.stream().map(f -> f.getName()).collect(Collectors.toList());
			return names;
		}
		
		public static List<File> getNonCompressedFileNames(){
			File[] files = getFiles();
			List<File> fileList = Arrays.asList(files);
			List<File> noncompressed = fileList.stream().filter(f -> !f.getName().endsWith("zip")).collect(Collectors.toList());
			return noncompressed;
		}
		
		public static void compressUncompressedFiles(){
			
		}
		
		
		
		public static String getFileContentsAsBytes(String fileName){
			return null;
		}
		
		public static String getFileContentsAsString(String fileName){
			return null;
		}
		
		
		
}
