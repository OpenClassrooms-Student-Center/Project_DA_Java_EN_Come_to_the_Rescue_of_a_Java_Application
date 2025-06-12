package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; // class reelle qui implemente List
import java.util.List;  // interface generique


public class ReadSymptomDataFromFile implements ISymptomReader {
	private String inputFilepath; 
	
	
	public ReadSymptomDataFromFile (String inputFilepath) {
		this.inputFilepath = inputFilepath; 
	}
		@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
		if (inputFilepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(inputFilepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close(); // on ferme pour liberer les ressources
			} catch (IOException e) {
				e.printStackTrace(); // Affiche l’historique complet des méthodes appelées jusqu’au moment où l’erreur s’est produite, pour aider à comprendre où et pourquoi le problème est survenu.
			}
		}
		
		return result;
	}

}
