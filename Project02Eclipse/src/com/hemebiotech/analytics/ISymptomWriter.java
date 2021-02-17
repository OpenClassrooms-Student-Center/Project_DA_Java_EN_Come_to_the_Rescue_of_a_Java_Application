package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {

	/**
	 * 
	 * Method signature that will write the results of the SymptomsCount Class on a text file.
	 * @param The TreeMap "mSympt" 
	 */	
	public Map<String,Integer> writeSymptomDataToFile (Map<String,Integer>mSympt) ;

}



