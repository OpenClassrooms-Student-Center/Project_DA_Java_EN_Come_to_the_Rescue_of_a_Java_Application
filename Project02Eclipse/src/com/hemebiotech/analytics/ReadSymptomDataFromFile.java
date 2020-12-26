package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	public String filepath;
	
    /**Constructors
    *
    */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
		
	}
	public ReadSymptomDataFromFile() {
		// TODO Auto-generated constructor stub
	}
	/**La méthode getSymptoms recupere la liste des symptoms depuis un fichier source et les integre dans une ArrayList
	 * @return tabSymptom
	 */
	@Override
	public ArrayList<String> getSymptoms() {
		ArrayList<String> tabSymptom = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					tabSymptom.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return tabSymptom;
	}

}

