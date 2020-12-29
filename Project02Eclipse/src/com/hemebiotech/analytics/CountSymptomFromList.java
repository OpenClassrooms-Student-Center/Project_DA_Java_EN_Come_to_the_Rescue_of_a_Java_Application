package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountSymptomFromList implements ISymptomCounter {

	/** methode qui permet de compter et trier les symptoms
	 * @param listResult
	 * @return mapOccurences
	 */
	@Override
	public Map<String, Integer> countSymptoms(List<String> list)  {
		  
		
		//Utilisation de treemap pour trier la map par ordre alphabétique
		TreeMap<String, Integer> mapOccurences = new TreeMap<String, Integer>();
	  
	    
		//On itère sur le tableau des symptoms.
		for (String symptom: list) {
				//On regarde si le symptom est déjà présent dans la table d'occurence.
				if (mapOccurences.containsKey(symptom)) {
					//Le symptom est présent dans la table d'occurence, on incrémente l'occurence de 1.
					mapOccurences.put(symptom, mapOccurences.get(symptom) + 1);
				} else {
					//Le symptom n'est pas présent dans la table d'occurence, on insère la note dans la table et on met l'occurence à 1.   
					mapOccurences.put(symptom, 1);
				}
				
		} 
	 
				//On affiche le résultat, c'est à dire les occurences des symptoms classés par ordre alphabétique.

      			mapOccurences.entrySet().forEach(System.out::println);
      	
	      
      			return mapOccurences;
	  
	
	  }
	

}
