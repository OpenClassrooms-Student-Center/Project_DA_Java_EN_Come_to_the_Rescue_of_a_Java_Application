package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write the count of occurrences from selected symptom data from a source
 * The important part is, the return value from the operation, which is a new file,
 * containing the symptom selected with the count of its occurrence.
 * 
 * The implementation does not need to order the list
 * 
 */
public interface IWriteSymptom {
	
	void writeSymptom(Map<String, Long> mapSymptoms, String nomFichier);
}



