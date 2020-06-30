package com.hemebiotech.analytics;

import java.io.IOException;// Package contenant la classe de gestion des exceptions
import java.nio.file.Files;// Package contenant la classe "Files" de gestion des fichiers
import java.nio.file.Paths;// Package contenant la classe "Paths" de gestion des chemins pour fichiers
import java.util.List;// Package contenant la classe List
import java.util.Map;// Package contenant la classe Map (collection)
import java.util.TreeMap;// Package contenant la classe TreeMap (Map ou collect triée par ordre croissant)
import java.util.function.Function;// Package contenant l'interface "Function" de gestion des fonctions
import java.util.stream.Collectors;// Package contenant la classe "Collectors" de gestion des grp d'objets/collections

public class SymptomesService {
	
	/**
	 * @param filename
	 */
	public void compterSymptomes(String filename){
		
		// Dans le bloc try-catch, le mot clé "try" contient tout ce qui peut générer des erreurs d'exception
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
	//return;
  }
}

