package com.hemebiotech.analytics;
 // Interface donnée 

import java.util.List;

/**
 * Tout ce qui permet de lire des données de symptômes depuis une source
 * L’élément important est la valeur retournée par cette opération, qui est une liste de chaînes de caractères,
 * et qui peut contenir de nombreuses duplications.
 * L’implémentation n’a pas besoin de trier la liste.
 * 
 */
public interface ISymptomReader {
	/**
	 * Si aucune donnée n'est disponible, retourne une liste vide.
	 * 
	 * @return une liste brute de tous les symptômes obtenus à partir d'une source de données. Des doublons sont possibles, voire probables.
	 */
	List<String> GetSymptoms ();
}
