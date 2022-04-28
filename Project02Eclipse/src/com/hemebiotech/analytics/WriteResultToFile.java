package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WriteResultToFile {
	private String filepath;
	private HashMap <String,Integer> result;
	
	
	public WriteResultToFile(String filepathOut, HashMap<String,Integer> res) {
		this.filepath=filepathOut;
		this.result=res;
	}
	
	public void write() {
		Map<String,Integer> mapResult = this.result;

		try {
			
			FileWriter writer = new FileWriter (this.filepath);
			BufferedWriter bw = new BufferedWriter(writer);
			
			for(Map.Entry<String, Integer> entry : mapResult.entrySet()) {
				bw.write(entry.getKey() + ": " + entry.getValue());
				bw.newLine();
				
			}
			bw.flush();
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
