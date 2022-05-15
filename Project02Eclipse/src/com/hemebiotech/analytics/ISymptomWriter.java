package com.hemebiotech.analytics;

/**
 * 
 * @author hayfaa
 *Anything that will write symptom data to a source
 *There is no need to return a particular value as long as writing innto source is carried out
 */

public interface ISymptomWriter {
	
	void write();

}
