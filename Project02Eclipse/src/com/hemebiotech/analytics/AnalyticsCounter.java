package com.hemebiotech.analytics; // declaration du package RAS

import java.io.BufferedReader; // import RAS
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {  			// declaration de la class principale utilisée pour traiter le fichier de symptoms. Static c’est-à-dire qu’elles appartiennent à la classe elle-même, et non à une instance.
	private static int headacheCount = 0;	// variable statique mais probleme car headacheCount pas utilisé donc forcement a 0
	private static int rashCount = 0;		// pb dans sa boucle, il y a ecris rush plutot que rash
	private static int pupilCount = 0;		// pb dans son output il y a ecris dialeted plutot que dilated
	
	public static void main(String args[]) throws Exception { // fonctionne mais le throws exception trop large car en gros je dis qu'il peut y avoir des erreurs ici mais je ne les geres pas. Le miuex c'est d'encapsuler des donnée sensyble avec try - catch
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt")); //  Lecture ligne par ligne du fichier.
		String line = reader.readLine();                                             // par contre comme le dit eclipse jamais fermée. Soit un reader.close() mais le probleme c'est que si erreur alors ne va pas jusqu'au bout soit meiux le try et catch

		int i = 0;	// Ok, mais i n’est jamais utilisé dans le programme – inutile.
		int headCount = 0;	
		while (line != null) { //  lecture jusqu’à la fin du fichier RAS
			i++;	// inutile car pas utilisé
			System.out.println("symptom from file: " + line); // affichage pour debug
			if (line.equals("headache")) { // pb dans la decla de variable plus haut
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) { // rush plutot que rash
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// « Je lis la ligne suivante dans le fichier, et je la mets dans la variable line. »
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n"); // headacheCount reste à zéro → il fallait utiliser headCount.
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n"); // "dialated" est mal orthographié, c’est "dilated".
		writer.close();
	}
}
