package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Ecrit la map dans une liste selon l'ordre d'une liste de symptomes 
 * @author Chilioa
 *
 */

public interface ISymptomWriter { 
	/**
	 * Ecrit la map dans une liste selon l'ordre d'une liste de symptomes
	 * @param symptoms
	 * @param listeSymptoms
	 */
	void symptomsWriter (Map<String, Integer> symptoms, List<String> listeSymptoms);

}
