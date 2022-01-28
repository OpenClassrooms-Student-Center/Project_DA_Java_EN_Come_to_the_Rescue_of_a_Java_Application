package com.hemebiotech.analytics;

/** 
 * 	@author Vincent Viomesnil
 *  TO DO : Compter les occurrences
 * 	TO DO : automatiser l'écriture du fichier.
 * 	TO DO : Voir si besoin d'une nouvelle méthode/Class pour mettre dans l'ordre ?
 * 	TO DO : faciliter l'écriture des symptoms à venir.
 *
 */

public class AnalyticsCounter {

	static final String inputFile = ".\\Project02Eclipse\\symptoms.txt";
	static final String outputFile = "result.out";
	
	

	public static void main(String[] args) throws Exception {
		
		ISymptomReader symptoms = new ReadSymptomDataFromFile(inputFile);
		symptoms.getSymptoms();
		
			}
	
	}

