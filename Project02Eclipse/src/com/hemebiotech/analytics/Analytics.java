package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Rayane Berrada
 * 
 * Interface to implement classes that will analyze and return
 * the analyzed data
 *
 */
public interface Analytics {

	/**
	 * This method is supposed to analyze and treat the data depending
	 * of the need of the class implemented
	 *
	 * @param symptomsList is the list of data that needs to be analyzed
	 */
	void analyze(List<String> symptomsList);
	
	/**
	 * 
	 * @return the data analyzed by the analyze method or an empty map if 
	 * no data has been analyzed
	 */
	public Map<String, Integer> getAnalyzedSymptoms();
}
