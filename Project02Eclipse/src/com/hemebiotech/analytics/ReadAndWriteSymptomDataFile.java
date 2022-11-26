package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Simple brute force implementation
 */
public class ReadAndWriteSymptomDataFile implements ISymptomReader {

	
	public ReadAndWriteSymptomDataFile() {
	}

	/**
	 * Read the list of symptoms
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */

	public List<String> GetSymptoms(String filepath) {
		List<String> result = new ArrayList<>();
		
			if (filepath != null) {
				try {
					BufferedReader reader = new BufferedReader (new FileReader(filepath));
				
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		return result;
	}
			return result;

}
	/**
     * write the sort of symptoms in the result.out file      
     * @see com.hemebiotech.analytics#ISymptomReader.writeFile(String fileOut, Map<String, Integer> groupedSymptoms)
     * @param groupedSymptoms 
     */
	public void writeFile(String fileOut, Map<String, Integer> groupedSymptoms) {
		try(FileWriter writer = new FileWriter(fileOut)) {
	for (Entry<String, Integer> key : groupedSymptoms.entrySet())	{
		writer.write(key.getKey() + "=" + groupedSymptoms.get(key.getKey()) + "\n");
	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> GetSymptoms() {

		return null;
	}
}
