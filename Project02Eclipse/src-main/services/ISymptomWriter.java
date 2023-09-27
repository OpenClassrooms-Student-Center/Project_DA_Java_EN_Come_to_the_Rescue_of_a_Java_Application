package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.SortedMap;

public interface ISymptomWriter {

	/**
	 * Method that writes data in support, data are recorded in a SortedMap<String, Integer>.
	 * @param SortedMap<String, Integer> listOfSymptoms
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	void writeSymptoms(SortedMap<String, Integer> listOfSymptoms) throws IOException, FileNotFoundException;
}
