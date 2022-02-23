package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public interface IWriteFinalDataFile {
/**
 * @author DOLLOU
 * @param map  
 * @throws IOException
 */
	public void writeData(Map<String, Integer> map) throws IOException;

}
