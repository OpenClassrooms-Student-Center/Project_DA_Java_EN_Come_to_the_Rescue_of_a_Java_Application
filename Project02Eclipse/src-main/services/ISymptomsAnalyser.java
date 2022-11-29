package services;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
/**
 * 
 * @author Sophie
 *
 */
public interface ISymptomsAnalyser {
	
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a listing of all Symptom and their occurrences obtained from a data source, duplicates are possible/probable
	 */
	
	SortedMap<String, Integer> analyseSymptoms(List<String> list);
}
