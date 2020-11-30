package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;



/**
 * La classe CountSymptom permet de récupérer une ArrayList et de l'intégrer dans une
 * HashMap, afin de recenser les occurrences par ordre alphabétique.
 * @author fouziahajji
 */
public class CountSymptom extends AnalyseCounter{
	



	/**
	 * @param result
	 * @return ListOccurences
	 * @throws IOException
	 */
	public static TreeMap<String, Integer> countSymptoms(List<String> result) throws IOException {
		  
		 
		
		//Cette table de hashage contiendra les occurences des symptoms
		TreeMap<String, Integer> ListOccurences = new TreeMap<String, Integer>();
	  
	  
	    
		//On itère sur le tableau des symptoms.
		for (int i = 0; i < result.size(); i++) {
	        //On récupère le symptom
			String symptom = result.get(i);
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

      		ListOccurences.entrySet()
//	      		.sorted(Map.Entry.<String, Integer>comparingByKey() ) 
      		.forEach(System.out::println);
		      
	      
	      
	      		return ListOccurences;
	  
		  
	    }
	  

}
