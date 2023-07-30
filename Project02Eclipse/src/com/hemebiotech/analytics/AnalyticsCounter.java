package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
//	 next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();


	}
/**
 * Créez le constructeur avec pour paramètres un objet de type
 * ISymptomReader et un objet de type ISymptomWriter. Ce
 * constructeur doit assigner les valeurs de ces deux paramètres à
 * deux attributs de classe.
 */
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;

	}

/**
 * Créez une méthode getSymptoms qui récupère la liste des entrées
 * dans le fichier en utilisant l’instance de ISymptomReader déjà
 * créée ;
 */
public List<String> getSymptoms() {
	ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile();
	List<String> symptoms = reader.GetSymptoms();
	return symptoms
	}

	/**
	 * Créez une méthode countSymptoms qui compte les occurrences
	 * de chaque symptôme existant ;
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCountMap = new HashMap<String, Integer>();

//		classic loop
//		for(int symptom=0;symptom<symptoms.length;symptom++){}

//		for-each loop
		for (String symptom : symptoms) {
			System.out.println(symptom);
			boolean isSymptomAlreadyExists = symptomCountMap.containsKey(symptom);
			if (isSymptomAlreadyExists){
				Integer count = symptomCountMap.get(symptom);
				count++;
			}
			else{
				Integer count = 1
			}
			symptomCountMap.put(symptom,count);
		}
		return symptomCountMap
	}


/**
 * Créez une méthode sortSymptoms qui trie la liste de symptômes
 * et d’occurrences par ordre alphabétique ;
 */
//Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCountMap);
public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
	return new TreeMap<>(symptoms);
}

/**
 * Créez une méthode writeSymptoms qui écrit le résultat dans le
 * fichier de sortie en utilisant l’instance de ISymptomWriter déjà
 * créée.
 */
public void writeSymptoms(Map<String, Integer> symptoms) {
	WriteSymptomDataToFile writer = new WriteSymptomDataToFile();
	writer.writeSymptoms(symptoms);

}

}
