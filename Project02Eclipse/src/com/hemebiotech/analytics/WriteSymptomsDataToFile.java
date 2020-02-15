package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomsDataToFile implements ISymptomWriter {
	private String filePath;
	
	public WriteSymptomsDataToFile(String pfilePath) {
		this.filePath = pfilePath.trim();
	}
	
	private String returnSpace(int symptomsLength, int count) {
		String spaces = "";
		for(int i = 0; i < count - symptomsLength; i++) {
			spaces += " ";
		}
		return spaces;
	}
	
	private String lineReturn(int listSize, int count) {
		return (count < listSize - 1) ? "\n" : "";
	}
	
	public void writeSymptoms(Map<String, Integer> symptomsList, boolean firstLetterIsCapital, boolean alignStatement){
		if (this.filePath != null || this.filePath != "") {
			try(FileWriter writer = new FileWriter(this.filePath)) {
				int i = 0;
				for (Map.Entry<String, Integer> entry : symptomsList.entrySet()) {
					if (firstLetterIsCapital) {
						if (alignStatement) {
							writer.write(
									entry.getKey().substring(0, 1).toUpperCase() 
									+ entry.getKey().substring(1)
									+ returnSpace(entry.getKey().length(), 25)
									+ ": "
									+ entry.getValue()
									+ lineReturn(symptomsList.size(), i)
							);
						} else {
							writer.write(
									entry.getKey().substring(0, 1).toUpperCase()
									+ entry.getKey().substring(1)
									+ " : "
									+ entry.getValue()
									+ lineReturn(symptomsList.size(), i)
							);
						}
					} else if (alignStatement) {
						writer.write(
								entry.getKey()
								+ returnSpace(entry.getKey().length(), 25)
								+ ": "
								+ entry.getValue()
								+ lineReturn(symptomsList.size(), i)
						);
					} else {
						writer.write(
								entry.getKey()
								+ " : "
								+ entry.getValue()
								+ lineReturn(symptomsList.size(), i)
						);
					}
					i++;
		        }
			} catch (IOException e) {
				  e.printStackTrace();
			}
		}
	}
}
