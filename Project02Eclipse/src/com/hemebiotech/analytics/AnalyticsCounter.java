package com.hemebiotech.analytics;

import java.util.List;

import com.hemebiotech.interfaces.ICounter;
import com.hemebiotech.interfaces.IGetSymptom;
import com.hemebiotech.interfaces.IOutFile;


public class AnalyticsCounter {
	

	public static void main(String args[]) throws Exception { 
	
		/**
		 * Instanciation des classes à travers les interfaces
		 */
	
		IGetSymptom listSymptom = new ReadSymptomDataFromFile();
		ICounter count = new SymptomCounter();
		IOutFile symptomOut = new SymptomOut();
		
		
		/**
		 * Obtention d'un Objet List à partir de la liste en .TXT
		 */
		List<String> getSymptom = listSymptom.GetSymptoms();
		
		
		 

		/**
		 * La méthode editFinalFile créé le fichier : results.out.txt. 
		 * Elle prend en argument l'objet SymptomCounter qui renvoie la liste des symptômes 
		 * dans l’ordre alphabétique, suivi du nombre d’occurrences 
		 * grâce à la List getSymptom fournit à la méthode SearchSymptomsAndCount() 
		 * 
		 */
	
		
		symptomOut.editFinalFile(count.SearchSymptomsAndCount(getSymptom));
		
		
		}
	
}
