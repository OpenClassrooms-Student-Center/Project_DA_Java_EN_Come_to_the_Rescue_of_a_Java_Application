package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Tout ce qui calculera les occurances d'une liste de symptomes parametre
 * d'entree est une liste de symptomes valeur de retour est une map de symptomes
 * 
 */
public interface ISymptomCalcul {

	/**
	 * @return renvoie une map non ordonner dont les clés sont les symptomes et les
	 *         valeurs sont le nombre d'occurance de ces symptomes
	 * @param une liste de symptome 
	 */
	Map<String, Integer> getMapSymptomes(List<String> listeSymptomes);
}
