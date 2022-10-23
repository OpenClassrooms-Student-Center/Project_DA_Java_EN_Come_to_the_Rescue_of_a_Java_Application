package com.hemebiotech.analytics;

<<<<<<< HEAD
public interface IWriteSymptom {

=======
import java.util.Map;

/**
 * Anything that will write the count of occurrences from selected symptom data from an external source
 * The important part is, the return value from the operation, which is a new file,
 * containing the symptom selected with the count of its occurrence.
 * 
 * The implementation need to order the list by alphabetical
 *
 */
public interface IWriteSymptom {
	
	void writeSymptom(Map<String, Long> mapSymptoms, String nomFichier);
>>>>>>> writer
}
