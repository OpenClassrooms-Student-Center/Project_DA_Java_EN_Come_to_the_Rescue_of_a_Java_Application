package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;
	
	/**
	 * 
	 * @param filePath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public List<String> GetSymptoms() {

		List<String> result = new ArrayList<String>();
		
		if (filePath != null) {
			
			try {
				FileReader freader = new FileReader(this.filePath);
				BufferedReader breader = new BufferedReader(freader);

				String line = breader.readLine();
				
				while (line != null) {
					result.add(line);
					line = breader.readLine();
				}
				freader.close();
				breader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return result;
	}
//		ArrayList<String> result = new ArrayList<String>();
//		
//		if (filePath != null) {
//			try {
//				BufferedReader reader = new BufferedReader (new FileReader(filePath));
//				String line = reader.readLine();
//				
//				while (line != null) {
//					result.add(line);
//					line = reader.readLine();
//				}
//				reader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return result;
//	}

}
