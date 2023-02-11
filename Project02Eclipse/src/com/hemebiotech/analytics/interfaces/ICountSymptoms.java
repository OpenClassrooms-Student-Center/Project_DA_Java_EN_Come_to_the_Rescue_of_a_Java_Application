package com.hemebiotech.analytics.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Agrège les symptômes transmis sous forme de Liste
 * 
 */
public interface ICountSymptoms {
	/**
	 * Retourne les données agrégées dans une structure Map à partir d'une liste en structure List
	 * 
	 * @return un dictionnaire trié par clé (symptomes) agrégé du nombre d'occurrence
	 */
	Map<String, Integer> countSymptomsLstToHash(List<String> lstSymptoms);
}
