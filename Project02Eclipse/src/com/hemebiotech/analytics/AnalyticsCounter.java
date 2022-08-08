package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class AnalyticsCounter {
	/* private static int rashCount = 0;
	private static int pupilCount = 0;*/

    public static void main(String[] args) throws Exception {
		/* BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;

		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);

			if (line.equals("headache")) {
				headCount++;
//				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}


		FileWriter writer = new FileWriter ("result.out");

//		int headacheCount = 0;

		writer.write("headache: " + headCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/

        File file = new File("symptoms.txt");

        String[] words;

        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;

//        On demande le symptôme recherché à l'utilisateur'
        System.out.println("Entrez un symptôme : (Appuyer sur entrer une fois fini)");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();


        int wordCount = 0;

        while ((str = bufferedReader.readLine()) != null) {
            words = str.split(" ");

            for (String word : words) {
                if (word.equals(search)) {
                    wordCount++;
                }
            }
        }

        if (wordCount != 0) {
            System.out.println("Symptom " + search + ": " + wordCount);
        } else {
            System.out.println("Le mot ne se trouve pas dans le fichier!");
        }
        fileReader.close();

    }
}
