package com.hemebiotech.analytics;

import java.util.List;

/**
 * Tout ce qui pourra lire les symptomes à partir d'une source de données. La
 * partie la plus importante est que la valeur retournée suite à ce traitement
 * est une liste de chaine de caractères pouvant contenir des données
 * dupliquées.
 *
 * 
 * L'implémentation ne nécessite pas de liste ordonnées
 * 
 */
public interface ISymptomReader {
	/**
	 * 
	 * Méthode permettant de récupérer une liste de symptomes à partir d'un fichier
	 * 
	 * Si aucune données n'est disponible, la liste retournée est vide
	 * 
	 * @return une liste brute de tout les symptomes récupérés depus la source de
	 *         données, les doublons sont possibles/probables.
	 * 
	 * 
	 */
	List<String> getSymptoms();
}
