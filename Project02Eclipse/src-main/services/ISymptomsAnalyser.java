package services;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface ISymptomsAnalyser {
	
	/**
	 * Method that returns a SortedMap filled with all symptoms and the number of occurrences of each, from a List of String.
	 * @param a List of String filled with all symptoms obtained from the data source (duplicates are possible/probable)
	 * @return a SortedMap<String, Integer> filled with all symptoms (key) and the number of occurrences of each (value)
	 * @return an empty SortedMap if no data is available 
	 */	
	SortedMap<String, Integer> analyseSymptoms(List<String> list);
}
