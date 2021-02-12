package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {

	/**
	 * 
	 * Method signature that will write the results of the SymptomsCount Class on a text file.
	 */	
	public Map<String,Integer> writeDataOnFile (Map<String,Integer>mSympt) throws IOException;

}



