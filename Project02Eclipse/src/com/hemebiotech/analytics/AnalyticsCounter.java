package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Classe permettant de compter le nombre de symptomes dans un fichier texte
 * 
 * @author Fouad
 * 
 * @param reader            Attribut de la Classe AnalyticsCounter de type
 *                          ISymptomReader
 * 
 * @param writer            Attribut de la Classe AnalyticsCounter de type
 *                          ISymptomWriter
 * 
 * @param counter           Attribut de la Classe AnalyticsCounter de type
 *                          ISymptomCounter
 * 
 * @param listSymptoms      Liste utilisé pour stocker les symptomes récupérés
 *                          par la méthode getSymtoms
 * 
 * @param occurenceSymptoms Map utilisé pour récupérer les symptomes avec leurs
 *                          occurences respectives
 * 
 * @return occurenceSymptoms Une liste de symptomes triées avec leurs occurences
 *         respectives
 * 
 * 
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;
	private ISymptomCounter counter;

	/**
	 * 
	 * @param providedReader
	 * @param providedWriter
	 * @param providedCounter
	 */
	public AnalyticsCounter(ISymptomReader providedReader, ISymptomWriter providedWriter,
			ISymptomCounter providedCounter) {
		this.reader = providedReader;
		this.writer = providedWriter;
		this.counter = providedCounter;
	}

	/**
	 * 
	 * @return listSymptoms retourne une liste de symptomes brutes
	 */
	public List<String> getSymptoms() {
		System.out.println("Lecture du fichier en cours...");

		List<String> listSymptoms = this.reader.getSymptoms();
		System.out.println("Lecture du fichier OK");
		return listSymptoms;
	}

	/**
	 * 
	 * @param symptoms
	 * @return occurenceSymptoms
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		System.out.println("Comptage des symptomes en cours...");

		Map<String, Integer> occurenceSymptoms = this.counter.getSymptomsOccurence(symptoms);
		System.out.println("Comptage des symptomes OK");

		return occurenceSymptoms;

	}

	/**
	 * 
	 * @param occurenceSymptoms
	 */
	public void writeSymptoms(Map<String, Integer> occurenceSymptoms) {

		System.out.println("Ecriture des résultats dans le fichier de sortie en cours...");

		this.writer.writeSymptom(occurenceSymptoms);
		System.out.println("Ecriture des résultats dans le fichier de sortie en cours OK");

	}

}
