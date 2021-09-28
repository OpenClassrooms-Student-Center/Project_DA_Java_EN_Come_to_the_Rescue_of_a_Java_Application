package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;
/*
 * interface de FileWriterData.
 */

public interface IFileWriterData {

	void writeSymptomsData(TreeMap<String, Integer> symptomsCompte) throws IOException;

}
