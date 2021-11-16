package com.hemebiotech.analytics;

import java.util.List;

/**
 * Tout ce qui lira les données de symptômes à partir d'une source La partie
 * importante est, le valeur de retour de l'opération, qui est une liste de
 * chaînes, pouvant contenir de nombreux doublons.
 * L'implémentation n'a pas besoin de trier la liste / The implementation does
 * not need to order the list
 * 
 */
public interface ISymptomReader {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return une liste de tous les symptômes obtenus à partir d'une source de donnée /
	 * raw listing of all Symptoms obtained from a data source
	 */
	List<String> getSymptoms();

}
