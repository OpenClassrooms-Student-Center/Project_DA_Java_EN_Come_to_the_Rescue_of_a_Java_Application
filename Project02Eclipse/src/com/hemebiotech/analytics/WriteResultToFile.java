package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WriteResultToFile implements ISymptomWriter{
	private String filepath;
	private Map<String,Integer> result;
	
	
	public WriteResultToFile(String filepathOut, Map<String,Integer> sortedSymptoms) {
		this.filepath=filepathOut;
		this.result=sortedSymptoms;
	}
	
	public void write() {

		try {
			
			FileWriter writer = new FileWriter (this.filepath);
			BufferedWriter bw = new BufferedWriter(writer);
			for(Map.Entry<String, Integer> entry:this.result.entrySet()) {
				bw.write(entry.getKey() + ":" + entry.getValue());
				bw.newLine();
			}
			bw.flush();
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
