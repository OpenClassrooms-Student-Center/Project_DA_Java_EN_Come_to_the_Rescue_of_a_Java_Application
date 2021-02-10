package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {

	/**
	 * Method signature that will writes the results of the SymptomsCount Class on a text file.
	 * @param Map <String, Integer>
	 * @return keys symptoms  and  nbOccurences values 
	 */


	public String writeDataOnFile ( Map<String,Integer>mSympt) throws IOException;


}
