package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */

public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptom obtained from a data source, duplicates are possible/probable
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	List<String> getSymptoms () throws FileNotFoundException, IOException;
}
