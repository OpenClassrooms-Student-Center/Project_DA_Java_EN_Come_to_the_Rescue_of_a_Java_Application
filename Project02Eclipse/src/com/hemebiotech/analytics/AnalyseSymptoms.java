package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;



/**
 * La classe AnalyseSymptoms permet de récupérer une ArrayList et de l'intégrer dans une
 * TreeMap, afin de recenser les occurrences par ordre alphabétique.
 * @author fouziahajji
 */
public class AnalyseSymptoms{
	

	/**
	 * @param list
	 * @return ListOccurences
	 */
	public Map<String, Integer> countSymptoms(ArrayList<String> list) {
		  
		 
		
		//Utilisation de treemap pour trier la map par ordre alphabétique
		TreeMap<String, Integer> ListOccurences = new TreeMap<String, Integer>();
	  
	 
	    
		//On itère sur le tableau des symptoms.
		for (String symptom: list) {
				//On regarde si le symptom est déjà présent dans la table d'occurence.
				if (ListOccurences.containsKey(symptom)) {
					//Le symptom est présent dans la table d'occurence, on incrémente l'occurence de 1.
					ListOccurences.put(symptom, ListOccurences.get(symptom) + 1);
				} else {
					//Le symptom n'est pas présent dans la table d'occurence, on insère la note dans la table et on met l'occurence à 1.   
					ListOccurences.put(symptom, 1);
				}
	    
				
		} 
	 
				//On affiche le résultat, c'est à dire les occurences des symptoms classés par ordre alphabétique.

      			ListOccurences.entrySet().forEach(System.out::println);
      		
		      
	      
	      
      			return ListOccurences;
	  
		  
	  }
	
	
	  
	

}
