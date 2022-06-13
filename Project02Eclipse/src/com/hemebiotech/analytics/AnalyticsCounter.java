package com.hemebiotech.analytics;


public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		/**
		 * listSymptom est un objet List, rempli par un fichier symptoms.txt grace à la class ReadSymptomDataFromFile
		 */
		ReadSymptomDataFromFile listSymptom = new ReadSymptomDataFromFile();
		
		/**
		 * La méthode editFinalFile créer un fichier : results.out.txt. 
		 * Elle prend en argument l'objet SymptomCounter qui renvoie la liste des symptômes 
		 * dans l’ordre alphabétique, suivi du nombre d’occurrences 
		 * grâce à la List listSymptom fournie à la méthode countOccurences() 
		 * 
		 */
		SymptomOut.editFinalFile(SymptomCounter.countOccurences(listSymptom));
		
		}
	
}
