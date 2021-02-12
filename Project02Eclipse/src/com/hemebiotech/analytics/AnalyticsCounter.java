package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class AnalyticsCounter {
	private static int symptomCount = 0;	// initialize to 0

	public static void main(String args[]) throws Exception {




		// get file from path
		String symptomsFile = new File ("Project02Eclipse/symptoms.txt").getCanonicalPath();	

		// create ReadSymptomDataFromFile and add path file in parameter
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(symptomsFile);

		// create variable "result" with function result in a array list
		ArrayList<String> result = (ArrayList<String>) reader.GetSymptoms();

		System.out.println(result);
		
		for (int i = 0; i < result.size(); i++) {
			
			
		}



//
//		while (result.get(i) != null) {
//			i++;
//
//			System.out.println(result.get(i));
//			else if (line.equals("rash")) {
//				rashCount++;
//			}
//			else if (line.contains("pupils")) {
//				pupilCount++;
//			}
//			line = reader.readLine();	// get another symptom
//		}


		// generate output file
		File resultTxt = new File("result.out");
		// write in file result.out
		FileWriter writer = new FileWriter(resultTxt);
		writer.write("headache: " + symptomCount + "\n");
		writer.close();


	}

}
