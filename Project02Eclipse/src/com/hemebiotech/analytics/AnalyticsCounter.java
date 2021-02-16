package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @version 1.0
 * 
 */
public class AnalyticsCounter implements IAnalyticsCounter {
	private String filepath;
	private String resultat;

	public AnalyticsCounter(String filepath, String resultat) {
		this.setFilepath(filepath);
		this.setResultat(resultat);
	}

	private TreeMap<String, Integer> treemapsymptom = new TreeMap<String, Integer>();

	@Override
	public void readSymptoms() {
		/**
		 * 
		 * @param filepath a full or partial path to file with symptom strings in it,
		 *                 one per line
		 */
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(getFilepath());
		List<String> symptomlu = reader.GetSymptoms();

		for (String symptom : symptomlu) {

			if (treemapsymptom.containsKey(symptom)) {

				Integer mavaleur = treemapsymptom.get(symptom);
				Integer neovaleur = Integer.valueOf(mavaleur.intValue() + 1);
				treemapsymptom.replace(symptom, neovaleur);

			} else {
				treemapsymptom.put(symptom, Integer.valueOf(1));
			}
		}
	}

	@Override
	public void saveSymptoms() throws IOException {

		FileWriter writer = null;
		try {
			writer = new FileWriter(resultat);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, Integer> entry : treemapsymptom.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
			try {
				writer.write("symptom : " + entry.getKey() + " " + entry.getValue() + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		writer.flush();
		writer.close();
	}

	public TreeMap<String, Integer> getTreemapsymptom() {
		return treemapsymptom;
	}

	public void setTreemapsymptom(TreeMap<String, Integer> treemapsymptom) {
		this.treemapsymptom = treemapsymptom;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
};
