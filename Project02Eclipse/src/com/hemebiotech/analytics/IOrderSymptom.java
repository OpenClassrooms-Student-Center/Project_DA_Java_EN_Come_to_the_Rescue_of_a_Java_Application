package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Tout ce qui ordonne une map par sa clé 
 * 
 */

public interface IOrderSymptom {
	
	/**
	 * @return renvoie une map ordonner dont les clés sont les symptomes et les
	 *         valeurs sont le nombre d'occurance de ces symptomes
	 * @param une map de symptome non  ordonner
	 */
	
	Map<String, Integer> order(Map<String, Integer> mapSymptome);

}
