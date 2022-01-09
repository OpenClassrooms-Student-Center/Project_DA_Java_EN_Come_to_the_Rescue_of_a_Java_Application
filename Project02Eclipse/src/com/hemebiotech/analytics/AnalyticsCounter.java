package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Classe permettant de compter le nombre de symptomes dans un fichier texte,
 * trier et compter les symptomes pour les écrire dans un fichier de sortie
 * 
 * @author Fouad
 * 
 * @param reader  Attribut de la classe AnalyticsCounter de type ISymptomReader
 * @param writer  Attribut de la classe AnalyticsCounter de type ISymptomWriter
 * @param counter Attribut de la classe AnalyticsCounter de type ISymptomCounter
 * 
 * 
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;
	private ISymptomCounter counter;

	/**
	 * 
	 * @param providedReader  paramètre du constructeur de la Classe pour l'attribut
	 *                        reader
	 * @param providedWriter  paramètre du constructeur de la Classe pour l'attribut
	 *                        writer
	 * @param providedCounter paramètre du constructeur de la Classe pour l'attribut
	 *                        counter
	 * 
	 * 
	 */
	public AnalyticsCounter(ISymptomReader providedReader, ISymptomWriter providedWriter,
			ISymptomCounter providedCounter) {
		this.reader = providedReader;
		this.writer = providedWriter;
		this.counter = providedCounter;
	}

	/**
	 * 
	 * @param listSymptoms Liste utilisé pour stocker les symptomes récupérés par la
	 *                     méthode getSymtoms
	 * 
	 * @return listSymptoms Retourne une liste de symptomes brutes
	 */
	public List<String> getSymptoms() {
		System.out.println("Lecture du fichier en cours...");

		List<String> listSymptoms = this.reader.getSymptoms();
		System.out.println("Lecture du fichier OK");
		return listSymptoms;
	}

	/**
	 * 
	 * @param symptoms Liste de symptomes brutes
	 * 
	 * @return occurenceSymptoms Liste de symptomes triées avec leurs occurences
	 *         respectives
	 * 
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		System.out.println("Comptage des symptomes en cours...");

		Map<String, Integer> occurenceSymptoms = this.counter.getSymptomsOccurence(symptoms);
		System.out.println("Comptage des symptomes OK");

		return occurenceSymptoms;

	}

	/**
	 * 
	 * @param occurenceSymptoms Map utilisé pour l'écriture des symptomes avec leurs
	 *                          occurences respectives
	 */
	public void writeSymptoms(Map<String, Integer> occurenceSymptoms) {

		System.out.println("Ecriture des résultats dans le fichier de sortie en cours...");

		this.writer.writeSymptom(occurenceSymptoms);
		System.out.println("Ecriture des résultats dans le fichier de sortie en cours OK");

	}

}
