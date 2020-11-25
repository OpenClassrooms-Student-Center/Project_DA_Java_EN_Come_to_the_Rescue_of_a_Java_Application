package com.hemebiotech.analytics;

import java.util.List;// Package containing the List class
import java.util.Map;// Package containing the Map class (collection)

/**
 * 
 * @author Dave Discamps
 *
 */

public interface ISymptomWriter {

	/**
	 * 
	 * @param mapSym
	 * @param symptoms
	 */

	void writeResult(Map<String, Integer> mapSym, List<String> symptoms);

}