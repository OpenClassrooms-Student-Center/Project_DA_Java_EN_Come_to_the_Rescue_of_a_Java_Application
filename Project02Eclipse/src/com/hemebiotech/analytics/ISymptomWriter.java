package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;



/**
 * @author fouziahajji
 * L'interface pour ecrire le resultat dans un fichier
 * 
 */
public interface ISymptomWriter {

    /**
     * Ecrit la map de symptomes dans le fichier result.out
     * @param list
     * @throws IOException
     * @author fouziahajji
     */

	void writeSymptoms(Map<String, Integer> list) throws IOException;
	
}
