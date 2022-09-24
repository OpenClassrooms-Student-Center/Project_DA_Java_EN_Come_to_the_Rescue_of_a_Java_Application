package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Tout ce qui prendra une map de clés valeurs en entrée et écrira dans un fichier (ou autre) en sortie 
 * 
 */

public interface ISymptomWriter {
	
	/**
	 *  @return cette fonction écrira dans un fichier de sortie
	 *  @param newMapSymptome : une map ordonner par sa clé
	 *  @param filePathOut : fichier de sortie ou les résultats vont etre affichés
	 */
	public void write(Map<String, Integer> newMapSymptome ,  String filePathOut);

}
