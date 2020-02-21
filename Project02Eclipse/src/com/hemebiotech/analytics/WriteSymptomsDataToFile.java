package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


/**
 * Simple brute force implementation
 * @author MrgnCpn
 */ 
public class WriteSymptomsDataToFile implements ISymptomWriter {
	private String filePath;
	
	/**
	 * 
	 * @param pfilePath a full or partial path to output file 
	 */
	public WriteSymptomsDataToFile(String pfilePath) {
		this.filePath = pfilePath.trim();
	}
	
	/**
	 * Method to align statements with spaces
	 * @param symptomsLength
	 * @param count, count of spaces needed
	 * @return String spaces
	 */
	private String returnSpace(int symptomsLength, int count) {
		String spaces = "";
		for(int i = 0; i < count - symptomsLength; i++) {
			spaces += " ";
		}
		return spaces;
	}
	
	
	/**
	 * Method to return backspaces or not to  avoid empty line in the end of file
	 * @param listSize, input list size
	 * @param count, count of line
	 * @return Backspace if we are in the file or nothing if the file is end
	 */
	private String lineReturn(int listSize, int count) {
		return (count < listSize - 1) ? "\n" : "";
	}
	
	/**
	 * @see com.hemebiotech.analytics.ISymptomWriter #writeSymptoms(Map, boolean, boolean)
	 */
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
