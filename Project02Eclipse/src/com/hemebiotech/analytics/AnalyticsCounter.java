//package com.hemebiotech.analytics;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//
//public class AnalyticsCounter {
//	private static int headacheCount = 0;	// initialize to 0
//	private static int rashCount = 0;		// initialize to 0
//	private static int pupilCount = 0;		// initialize to 0
//	
//	public static void main(String args[]) throws Exception {
//		// first get input
//		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
//		String line = reader.readLine();
//
//		int i = 0;	// set i to 0
//		int headCount = 0;	// counts headaches
//		while (line != null) {
//			i++;	// increment i
//			System.out.println("symptom from file: " + line);
//			if (line.equals("headache")) {
//				headCount++;
//				System.out.println("number of headaches: " + headCount);
//			}
//			else if (line.equals("rush")) {
//				rashCount++;
//			}
//			else if (line.contains("pupils")) {
//				pupilCount++;
//			}
//
//			line = reader.readLine();	// get another symptom
//		}
//		
//		// next generate output
//		FileWriter writer = new FileWriter ("result.out");
//		writer.write("headache: " + headacheCount + "\n");
//		writer.write("rash: " + rashCount + "\n");
//		writer.write("dialated pupils: " + pupilCount + "\n");
//		writer.close();
//	}
//}


package com.hemebiotech.analytics;

import java.io.IOException;// Package contenant la classe de gestion des exceptions
import java.nio.file.Files;// Package contenant la classe "Files" de gestion des fichiers
import java.nio.file.Paths;// Package contenant la classe "Paths" de gestion des chemins pour fichiers
import java.util.List;// Package contenant la classe List
import java.util.Map;// Package contenant la classe Map (collection)
import java.util.TreeMap;// Package contenant la classe TreeMap (Map ou collect triée par ordre croissant)
import java.util.function.Function;// Package contenant l'interface "Function" de gestion des fonctions
import java.util.stream.Collectors;// Package contenant la classe "Collectors" de gestion des grp d'objets/collections

// Notre code doit être optimal (dynamique) de sorte qu'en modifiant la BDD (augmentation du nb de sympt),
// qu'on n'ait pas à modifier le code

public class AnalyticsCounter {

	public static String filename = "symptoms.txt";// Déclaration du fichier texte à lire

	public static void main(String args[]) throws Exception// Une exception est levée grâce à l'instruct "throw"
	{

		// Dans le bloc try-catch, le mot clé "try" contient tout ce qui peut générer
		// des erreurs d'exception
		try {
			
			// Lecture de toutes les lignes du fichier symptômes
			List<String> lines = Files.readAllLines(Paths.get(filename));

			// déclarat d'1 var de type Map (carte) qui compte les lignes (courantes)
			Map<String, Long> compteurs = lines.stream()

					// instruction spécifiant que l'on souhaiterait compter les éléments de chaque groupe
					// (avec une surcharge de collection)
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			// déclarat d'une var de type TreeMap qui trie les précédentes lignes comptées
			TreeMap<String, Long> compteurstri = new TreeMap<>();

			// putALL est une méth de la classe Map use pour copier cpt vers cpttri
			compteurstri.putAll(compteurs);

			// déclarat d'1 liste de chaines de car et conversion map (carte)en list
			List<String> finallines = compteurstri.entrySet().stream()

					// On récupère la clé (donc la ligne) et le nb d'occurr
					.map(entry -> entry.getKey() + ": " + entry.getValue())

					// transforme tous ces résultats en liste
					.collect(Collectors.toList());

			// Ecrire sur le fichier "r.out" la précédente liste triée et complétée
			// par les bonnes valeurs; puis, le récupérer
			Files.write(Paths.get("resultats.out"), finallines);

		}

		// permet de récupérer une éventuelle erreur d'exception. La méthode
		// "printStackTrace" permet d'afficher les lignes du code en erreur
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}