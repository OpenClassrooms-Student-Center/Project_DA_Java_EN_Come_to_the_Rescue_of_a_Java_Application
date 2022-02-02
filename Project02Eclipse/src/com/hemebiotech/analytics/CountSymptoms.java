package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;


/** @return compteurs = retourne le nombre d'occurences contenues dans la map compteurs.
* @param compte l'ensemble des éléments présents dans la map */ 

public class CountSymptoms {
	
	public TreeMap<String, Integer> nbOccurrence(List<String> symptomsList) {

		TreeMap<String, Integer> compteurs = new TreeMap<String, Integer>();

		for(String symptom : symptomsList) {	/** Boucle sur chaque élément "symptom" contenu dans ma liste de symptomes */
			if (compteurs.containsKey(symptom)) {	/** on analyse si le symptome existant dans la Map*/
																  
				compteurs.put(symptom, compteurs.get(symptom)+1); /** Si symptome existant, alors on va l'incrémenter de 1 */
				
			} else {
				compteurs.put(symptom, 1); /** Si le symptome n'existe pas, on va lui mettre 1 en valeur */
			}
		}
		return compteurs; /** retourne le résultat de la map compteurs */ 
	
	}
}