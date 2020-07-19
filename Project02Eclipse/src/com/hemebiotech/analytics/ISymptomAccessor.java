package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Anything that will read symptom data from a source.<br/>
 * The important part is the return value from the operation, which is a list of
 * strings, that may contain many duplications.<br/>
 * 
 * The implementation does not need to order the list.
 * 
 */

public interface ISymptomAccessor {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return A listing of all Symptoms obtained from a data source, duplicates are
	 *         possible/probable.<br/>
	 *         Empty elements are discarded.<br/>
	 *         Elements are trimmed and set to upper case.<br/>
	 * @author Yassine PAYET
	 */

	List<String> GetSymptom() throws IOException;

}
