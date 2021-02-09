package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * 
	 * 
	 */
	public Map <String, Integer> sCount () {


		ISymptomReader lecteur = new ReadSymptomDataFromFile("symptoms.txt");

		List<String> lSymptoms = lecteur.GetSymptoms();

		Map<String,Integer> mSympt = new HashMap<>();

		try {
			for (int n = 0; n>lSymptoms.size(); n++) {

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
		}
		catch (Exception SymptomsCount) {
			System.out.println("Ceci est une erreur de la methode SymptomCount");
		}

		return mSympt;

	}
}
