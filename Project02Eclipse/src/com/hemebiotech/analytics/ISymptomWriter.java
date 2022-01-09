package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface ISymptomWriter définit un contrat de service pour l'écriture d'une
 * liste de symptomes triés avec leurs occurences respectives vers un fichier
 * 
 * @author Fouad
 * @param sortedSymptoms liste de symptomes trié par odre alphabétique
 */
public interface ISymptomWriter {
	/**
	 * 
	 * Méthode permettant d'écrire une liste de symptomes à partir dune Map
	 * 
	 * @param sortedSymptoms Liste de type Map de symptomes triés avec leurs
	 *                       occurences respectives
	 * 
	 */
	void writeSymptom(Map<String, Integer> sortedSymptoms);

}
