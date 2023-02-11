/**
 * 
 */
package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.interfaces.ICountSymptoms;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.IWriteSymptomToFile;

/**
 * Agrège les différents symptomes depuis un fichier Symtoms.txt dans un nouveau fichier result.out
 * @Return void
 * @author Laurent
 * @Version 1.0
 */
public class Analytics {

	/**
	 * @param args
	 */
	
	private static List<String> lstSymptoms;
	
	public static void main(String[] args) {
		String strFilePath = "symptoms.txt";
		Map<String, Integer> hashSymptoms = new HashMap<>();
		
		ISymptomReader myReadSymptomDataFromFile = new ReadSymptomDataFromFile(strFilePath);
		lstSymptoms = myReadSymptomDataFromFile.getSymptoms();
		
		ICountSymptoms myIcountSymptoms = new CountSymptoms();
		hashSymptoms = myIcountSymptoms.countSymptomsLstToHash(lstSymptoms);
		
		IWriteSymptomToFile myWriteSymptomToFile = new WriteSymptomToFile("result.out");
		myWriteSymptomToFile.writeSymptom(hashSymptoms); 
	}
}
