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
<<<<<<< HEAD
     * @param list
     * @throws IOException
     * @author fouziahajji
     */

	void writeSymptoms(Map<String, Integer> list) throws IOException;
=======
     *
     * @throws IOException
     *
     * @return un fichier avec le nombre de chaque symptomes
     *
     * @author fouziahajji
     */

	void writeSymptoms(Map<String, Integer> map) throws IOException;
>>>>>>> 4555bc06e8910c00005375f64aee5859e77f7918
	
}
