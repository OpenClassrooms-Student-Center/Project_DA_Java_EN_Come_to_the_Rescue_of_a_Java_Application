package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
/*    private static int rashCount = 0;
    private static int pupilCount = 0;*/

    public static void main(String[] args) throws Exception {
/*        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();

        int i = 0;
        int headCount = 0;

        while (line != null) {
            i++;
            System.out.println("symptom from file: " + line);

            if (line.equals("headache")) {
                headCount++;
//				System.out.println("number of headaches: " + headCount);
            } else if (line.equals("rush")) {
                rashCount++;
            } else if (line.contains("pupils")) {
                pupilCount++;
            }

            line = reader.readLine();    // get another symptom
        }


        FileWriter writer = new FileWriter("result.out");

//		int headacheCount = 0;

        writer.write("headache: " + headCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();*/

//        Utiliser les map pour pouvoir extraire les symptomes du fichier

        File file = new File("symptoms.txt");

        Map<String, Integer> mapSymptomWithNumberOccurence = new TreeMap<>();
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        

        while ((str = bufferedReader.readLine()) != null) {
            
            if (mapSymptomWithNumberOccurence.containsKey(str)){
                // on incrémente la valeur existante
                int countOccurence = mapSymptomWithNumberOccurence.get(str);
                countOccurence++;
                mapSymptomWithNumberOccurence.replace(str, countOccurence);
            } else {
                mapSymptomWithNumberOccurence.put(str, 1);
            }

            
            // affficher le symptom
//            words = str.split(" ");
//
//            for (String word : words) {
//                if (word.equals(search)) {
//                    wordCount++;
//                }
//            }
        }

        for (String symptom : mapSymptomWithNumberOccurence.keySet()) {
            System.out.println(symptom + ":" + mapSymptomWithNumberOccurence.get(symptom));
        }

//        if (wordCount != 0) {
//            System.out.println("Symptom " + search + ": " + wordCount);
//        } else {
//            System.out.println("Le mot ne se trouve pas dans le fichier!");
//        }
        fileReader.close();

    }
}
