package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * 
 * Classe principale contenant la méthode main servant à lancer les traitements
 * pour récupérer une iste de symptomes triés et comptabilisés
 * 
 * @author Fouad
 * 
 */

public class Main {

	/**
	 * 
	 * @param args Contient les arguments de ligne de commande fournis sous la forme
	 *             d'un tableau de String d'objets
	 * 
	 * @throws Exception Utilisé pour lever des exception qui ne peuvent être
	 *                   ignorées
	 * 
	 * @param reader             Variable de type ISymptomReader utilisé pour la
	 *                           lecture du fichier de symptomes et la création
	 *                           d'une instance AnalyticsCounter
	 * 
	 * @param counter            Variable de type ISymtomCouner utilisé pour le
	 *                           comptage des symptomes et la création d'une
	 *                           instance AnalyticsCounter
	 * 
	 * @param writer             Variable de type ISymptomWriter utilisé pour
	 *                           l'écriture de la liste des symptomes triés avec
	 *                           leurs occurences respectives et la création d'une
	 *                           instance AnalyticsCounter
	 * 
	 * @param instance           Variable utilisée pour création d'un objet
	 *                           AnalyticsCounter
	 * 
	 * @param symptoms           Variable permettant la récupération des symtomes
	 *                           dans une liste de type String
	 * 
	 * @param occurencesSymptoms Variable utilisée pour contenir la liste des
	 *                           symptomes avec leurs occurences respectives et leur
	 *                           écriture dansun fichier de sortir
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
