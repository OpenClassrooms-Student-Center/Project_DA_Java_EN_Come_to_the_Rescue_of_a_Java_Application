package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.SortedMap;

/**
 * 
 * @author Sophie
 *
 */
public interface ISymptomWriter {

	/**
	 * 
	 * @param listOfSymptoms
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	void writeSymptoms(SortedMap<String, Integer> listOfSymptoms) throws IOException, FileNotFoundException;
}
