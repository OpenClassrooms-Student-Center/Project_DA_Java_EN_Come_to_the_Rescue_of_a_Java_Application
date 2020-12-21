package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * @author fouziahajji
 * Anything that will write symptom data to a source
 * 
 */
 
public interface ISymptomWriter {

	

	void writeSymptoms(Map<String, Integer> MapList) throws IOException;
	
}
