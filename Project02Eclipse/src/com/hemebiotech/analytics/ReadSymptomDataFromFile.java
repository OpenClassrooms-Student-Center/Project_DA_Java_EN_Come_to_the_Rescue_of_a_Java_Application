package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	public static final String MESSAGE_FILE_NOT_FOUND = "Le fichier symptomes.txt n'est pas présent en entrée - arrêt du traitement";
	public static final String MESSAGE_OTHER_IO_ERROR = "Problème de lecture du fichier symptomes.txt - arrêt du traitement";

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public ArrayList<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println(MESSAGE_FILE_NOT_FOUND);
				System.exit(-1);
			} catch (IOException e) {
				System.out.println(MESSAGE_OTHER_IO_ERROR);
				System.exit(-1);
			}
		}
		
		return result;
	}

}
