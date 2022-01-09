package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Interface ISymptomCounter définit un contrat de service pour le comptage des
 * symptomes, la valeur retournée contiendra une liste de symptomes avec leurs
 * occurences respectives
 * 
 * @author Fouad
 * 
 */
public interface ISymptomCounter {
	/**
	 * Méthode permettant de compter le nombre d'occurence d'un symptome dans la Map
	 * retournée
	 * 
	 * @param list_symptoms List contenant la liste des symptomes brutes lu dans le
	 *                      fichier
	 * 
	 * @return Une Map contenant les symptomes avec leurs occurences respectives
	 */
	Map<String, Integer> getSymptomsOccurence(List<String> list_symptoms);

}
