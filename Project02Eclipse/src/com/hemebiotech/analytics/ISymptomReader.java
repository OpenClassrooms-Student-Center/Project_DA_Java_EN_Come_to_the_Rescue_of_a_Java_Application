package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface ISymptomRear définit tout ce qui pourra lire les symptomes à partir
 * d'une source de données. La partie la plus importante est que la valeur
 * retournée suite à ce traitement est une liste de chaine de caractères ouvant
 * contenir des données dupliquée.
 *
 * 
 * L'implémentation ne nécessite pas de liste ordonnées
 * 
 * @author Fouad
 * 
 */
public interface ISymptomReader {
	/**
	 * Si aucune données n'est disponible, la liste retournée est vide
	 * 
	 * @return une liste brute de tout les symptomes récupérés depus la source de
	 *         données, les doublons sont possibles/probables.
	 * 
	 * 
	 */
	List<String> getSymptoms();
}
