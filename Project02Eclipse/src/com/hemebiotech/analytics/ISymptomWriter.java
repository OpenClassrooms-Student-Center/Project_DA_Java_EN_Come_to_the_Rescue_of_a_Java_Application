package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface ISymptomWriter définit un contrat de service pour l'écriture d'une
 * liste de symptomes triés dans un fichier de sortie
 * 
 * @author Fouad
 * 
 */
public interface ISymptomWriter {
	/**
	 * 
	 * @param sortedSymptoms liste de symptomes trié par odre alphabétique avec
	 *                       leurs occurences respectives
	 */
	void writeSymptom(Map<String, Integer> sortedSymptoms);

}
