package com.hemebiotech.analytics;

import java.util.List;

/**
 * L'interface ISymptomReader définit la méthode pour lire les symptômes.
 */
public interface ISymptomReader {
	/**
	 * On récupère la liste des symptômes.
	 */
	List<String> getSymptoms ();
}
