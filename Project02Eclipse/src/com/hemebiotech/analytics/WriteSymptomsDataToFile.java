package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomsDataToFile implements ISymptomWriter {
	private String filePath;
	
	public WriteSymptomsDataToFile(String pfilePath) {
		this.filePath = pfilePath.trim();
	}
	
	public void writeSymptoms(Map<String, Integer> symptomsList){
		if (this.filePath != null || this.filePath != "") {
			try(FileWriter writer = new FileWriter(this.filePath)) {
				for (Map.Entry<String, Integer> entry : symptomsList.entrySet()) {
					writer.write(
							entry.getKey()
							+ " : "
							+ entry.getValue()
							+ "\n"
					);
		        }
			} catch (IOException e) {
				  e.printStackTrace();
			}
		}
	}
}
