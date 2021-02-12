package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsCount {


	/**
	 * @author E.Jurquet
	 * 
	 * @return a list of an HashMap keys are Symptoms and values occurrences for each symptom.
	 * The keys are listed by alphabetical order.
	 * 
	 * This Method uses and instantiate the method "ReadSymptomDataFromFile" and the interface ISymptomReader.  
	 * @see ReadSymptomDataFromFile
	 * @see ISymptomReader
	 */
	public  Map<String,Integer> listAndCountSymptoms  () {


		ISymptomReader lecteur = new ReadSymptomDataFromFile("/Users/catherinejurquet/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application2/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt");

		List<String> lSymptoms = lecteur.getSymptoms();

		Map<String,Integer> mSympt = new TreeMap<>();

		try {
			for (int n = 0; n<lSymptoms.size(); n++) {
				String symptome = lSymptoms.get(n).trim().toLowerCase();

				if (mSympt.containsKey(symptome)) {
					int nbOccurence = mSympt.get(symptome);
					nbOccurence ++;
					mSympt.put(symptome, nbOccurence);
				}
				
				else {
					mSympt.put(symptome,1);
				}
			}
			System.out.println(mSympt.toString());

		}catch (Exception symptome) {
			System.out.println("This error could be caused by listAndCountSymptoms method."); 
		} 

		return mSympt;
	}
}
