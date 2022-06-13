package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  
 * Transformation de la liste des symptomes du fichier symptoms.txt en List 
 */

public class ReadSymptomDataFromFile{
	
	// Chemin du fichier à lister
	File file = new File ("Project02Eclipse/symptoms.txt");
	
	/**
	 * 
	 * @return L'objet List rempli 
	 */
	public List<String> GetSymptoms() {

		List<String> result = new ArrayList<String>();  
		
		if (file != null) {
			try(BufferedReader reader = new BufferedReader (new FileReader(file))){
				
				String line = reader.readLine();
				
				// Tant que le Buffered à des lignes à lire, il les ajoute à la List result
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				
				reader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
