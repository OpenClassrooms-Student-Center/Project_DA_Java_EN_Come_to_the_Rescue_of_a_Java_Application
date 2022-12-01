package impl;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import services.ISymptomsAnalyser;

public class AnalyseSymptomsFromList implements ISymptomsAnalyser {

	/**
	 * Method that returns a SortedMap filled with all symptoms and the number of occurrences of each, from a List of String.
	 * @param a List of String filled with all symptoms obtained from the data source (duplicates are possible/probable)
	 * @return a SortedMap<String, Integer> filled with all symptoms (key) and the number of occurrences of each (value)
	 * @return an empty SortedMap if no data is available 
	 */	
	@Override
	public SortedMap<String, Integer> analyseSymptoms(List<String> listSymptomsString) {

		SortedMap<String, Integer> listSymptomsAndOccurrence = new TreeMap<String, Integer>();

		for (String s : listSymptomsString) {

			if (listSymptomsAndOccurrence.isEmpty()) {
				listSymptomsAndOccurrence.put(s, 1);
			} else {

				if (listSymptomsAndOccurrence.containsKey(s)) {
					listSymptomsAndOccurrence.replace(s, (listSymptomsAndOccurrence.get(s) + 1));
				} else {
					listSymptomsAndOccurrence.put(s, 1);
				}
			}
		}
		return listSymptomsAndOccurrence;

	}

}
