package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * 
 * Classe principale contenant la méthode main servant à lancer les traitements
 * pour récupérer une iste de symptomes triés et comptabilisés
 * 
 * @author Fouad
 * @param args
 * @param reader             de type ISymptomReader utilisé pour la lecture du
 *                           fichier de symptomes
 * @param counter            de type ISymtomCouner utilisé pour le comptage des
 *                           symptomes
 * @param writer             de type ISymptomWriter utilisé pour l'écriture de
 *                           la liste des symptomes triés avec leurs occurences
 *                           respectives
 * @param instance           variable utilisée pour création d'un objet
 *                           AnalyticsCounter
 * @param symptoms           variable permettant la récupération des symtomes
 *                           dans une liste de type String
 * @param occurencesSymptoms variable utilisée pour contenir la liste des
 *                           symptomes avec leurs occurences respectives
 */

public class Main {

	/**
	 * 
	 * @param args
	 * @throws Exception
	 * 
	 */

	public static void main(String args[]) throws Exception {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomCounter counter = new SymptomsCounter();
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

		AnalyticsCounter instance = new AnalyticsCounter(reader, writer, counter);

		List<String> symptoms = instance.getSymptoms();
		Map<String, Integer> occurenceSymptoms = instance.countSymptoms(symptoms);
		instance.writeSymptoms(occurenceSymptoms);

	}

}
