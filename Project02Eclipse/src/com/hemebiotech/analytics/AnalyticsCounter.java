package com.hemebiotech.analytics;


public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception { 
		/**
		 * listSymptom est un Objet List, rempli par le fichier symptoms.txt grace à la classe ReadSymptomDataFromFile
		 */
		ReadSymptomDataFromFile listSymptom = new ReadSymptomDataFromFile();
		
		/**
		 * La méthode editFinalFile créé le fichier : results.out.txt. 
		 * Elle prend en argument l'objet SymptomCounter qui renvoie la liste des symptômes 
		 * dans l’ordre alphabétique, suivi du nombre d’occurrences 
		 * grâce à la List listSymptom fournit à la méthode countOccurences() 
		 * 
		 */
		SymptomOut.editFinalFile(SymptomCounter.countOccurences(listSymptom));
		
		}
	
}
