package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		Map<String, Integer> dico = new HashMap<String,Integer>();
		List<String> listSymptom = new ArrayList<String>();
		
		while (line != null) {
			
			System.out.println("symptom from file: " + line);
			//ajout des symptoms
			if (dico.containsKey(line)) {
				dico.put(line, dico.get(line)+1);
			}else {
				listSymptom.add(line);
				dico.put(line, 1);
				// sort des symtpoms
				if(listSymptom.size()==1) {
					
				}else if(listSymptom.size()==2) {
					if(listSymptom.get(1).compareTo(listSymptom.get(0))<0) {
						String tmp = listSymptom.get(0);
						listSymptom.set(0, listSymptom.get(1));
						listSymptom.set(1, tmp);
					}
				}else {
					int indice = listSymptom.size()-1;
					boolean flag = false;
					while (indice>0 && !flag) {
						if (listSymptom.get(indice-1).compareTo(listSymptom.get(indice))>0) {
							String tmp = listSymptom.get(indice-1);
							listSymptom.set(indice-1, listSymptom.get(indice));
							listSymptom.set(indice, tmp);
						}else {
							flag = true;
						}
						indice--;
					}
				}
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.txt");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
