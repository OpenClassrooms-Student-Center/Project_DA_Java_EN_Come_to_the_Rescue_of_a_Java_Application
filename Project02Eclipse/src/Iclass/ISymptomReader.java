package com.hemebiotech.analytics;
 
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
	 * @return une liste brute de tous les symptômes obtenus à partir d'une source de données. Des doublons sont possibles, voire probables.
	 */
	List<String> getSymptoms (); // "Cette interface définit une méthode GetSymptoms qui, 
								//	lorsqu’elle sera implémentée par une classe, devra renvoyer une liste brute 
								// de tous les symptômes obtenus
								// à partir d’une source de données. La liste peut contenir des doublons."
}
