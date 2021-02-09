package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author E.Jurquet
 * 
 * Main Class of the Program AnalyticsCounter.  well as a treemap method.
 * @version 1.1
 *
 */
public class AnalyticsCounter {
	/**
	 * Instanciate 2 methods (@see)
	 * Instanciate 2 Maps : "results" and "ordre"
	 *@see  SymptomCount
	 *@see  WriteData
	 *@throws an error who can occure during the execution of write the results of the Map on a file txt.
	 */
	public void analysis () {

		SymptomsCount analyticscompute = new SymptomsCount();
		WriteData wd =  new  WriteData ();

		Map<String,Integer> results = analyticscompute.sCount();
		System.out.println(results);

		Map<String,Integer> ordre = treemap(results);

		String resultats = null;
		try {
			resultats = wd.writedata(ordre);
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(resultats);

		System.out.println(ordre);
	}
	/**
	 * @return  a new TreeMap who classify by  alphabetical order the results of the method "analysis"
	 */
	public Map<String,Integer> treemap (Map<String, Integer>mSympt) {

		Map<String,Integer> sorties = new TreeMap<>(mSympt);

		sorties.putAll(mSympt);

		return sorties;
	}
	/**
	 * Program Start
	 * @param args
	 * @throws IOException
	 *
	 *  This is the main start of the program.
	 *  Instantiate the Analytics class and use the analysis method.
	 */
	public static void main  ( String[] args )throws IOException {

		AnalyticsCounter analytics = new AnalyticsCounter () ;


		analytics.analysis();
	}
}

	/**
	 * private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}*/
