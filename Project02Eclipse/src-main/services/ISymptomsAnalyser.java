package services;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import obj.ListSymptoms;

public interface ISymptomsAnalyser {
	
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a listing of all Symptom and their occurrences obtained from a data source, duplicates are possible/probable
	 */
	
	// Version modifiée
	SortedMap<String, Integer> AnalyseSymptoms(List<String> list);

	// Version intermédiaire
//	ListSymptoms AnalyseSymptoms(List<String> list);
	
	// Version initiale
//	ListSymptoms AnalyseSymptoms();
}
