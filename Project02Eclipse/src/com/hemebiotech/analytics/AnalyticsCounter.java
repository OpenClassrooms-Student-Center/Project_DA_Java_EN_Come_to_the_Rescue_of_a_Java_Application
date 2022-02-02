package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/** 
 * 	@author Vincent Viomesnil
 *  OK: Compter les occurrences
 * 	TO DO : automatiser l'écriture du fichier.
 * 	TO DO : Voir si besoin d'une nouvelle méthode/Class pour mettre dans l'ordre ?
 *
 */

public class AnalyticsCounter {

	static final String inputFile = ".\\Project02Eclipse\\symptoms.txt";
	static final String outputFile = "result.out"; 
	
	public static void main(String[] args) throws Exception {
		
		ISymptomReader reader = new ReadSymptomDataFromFile(inputFile); /** Lecture du fichier contenant la liste des symptomes */
		List<String> symptomsList = reader.getSymptoms(); /** affectation de la liste "symptomsList" au fichier de lecture */ 
		TreeMap<String, Integer> mapOccurrence = new TreeMap<String, Integer>(); /** Création de la Map "mapOccurrence" */ 	
		
		ISymptomWriter writer = new WriteSymptomOnFile(outputFile);
		
		CountSymptoms compteurs = new CountSymptoms(); /** Instanciation de l'objet "compteurs" de la classe "CountSymptoms" */ 
		mapOccurrence = compteurs.nbOccurrence(symptomsList); /** Lecture du nb d'occurrences à partir de la map */
		
		System.out.println(mapOccurrence); /** Affichage du nombre d'occurrences par symptome depuis la liste des symptomes */
		
		writer.writeSymptoms(mapOccurrence); /** Ecriture dans le fichier externe "result.out" du nombre d'occurrence par symptome */
		
		}
}