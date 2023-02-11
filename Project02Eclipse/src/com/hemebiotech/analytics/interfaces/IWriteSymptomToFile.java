package com.hemebiotech.analytics.interfaces;

import java.util.Map;

/**
 * Ecrit dans un fichier result.out un dictionnaire de type Map<String, Integer>
 * 
 */
public interface IWriteSymptomToFile {
	/**
	 * Write symptoms in a file
	 * @param Symptoms Map
	 * 
	 * @Return void
	 * @author Laurent
	 * @Version 1.0
	 *
	 */
	public void writeSymptom(Map<String, Integer> hashSymptoms);
}
