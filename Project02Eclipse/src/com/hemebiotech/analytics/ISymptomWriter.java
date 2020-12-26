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

<<<<<<< HEAD
	void writeSymptoms(Map<String, Integer> list) throws IOException;

 

=======
	void writeSymptoms(Map<String, Integer> map) throws IOException;
	
>>>>>>> 8126feb3ce7f7d5829488901393bbcea18c9eb6a
}

