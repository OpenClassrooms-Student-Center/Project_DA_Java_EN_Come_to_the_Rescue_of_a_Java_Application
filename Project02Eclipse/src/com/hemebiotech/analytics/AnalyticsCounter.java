package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class AnalyticsCounter {
	
	/**
	 * creates a local static file named filesorting.
	 */
	static File fileSorting = new File("sortingFile.txt");
	
	
    /**
     * 
     * @param args
     * @throws Exception
     */
	public static void main(String args[]) throws Exception {
         AnalyticsCounter counting = new AnalyticsCounter();
		counting.countingOccunrenceOfSyptoms() ;
		
		 AnalyticsCounter sorting = new AnalyticsCounter();
		sorting.sortingSyptomsAlphabetically();
		
		 AnalyticsCounter reading = new AnalyticsCounter();
		reading.readingSyptomsFromIsymtomReader();
	}

	/**
	 * 
	 * @return  list of files from the class ReadSymptomDataFromFile
	 */
	public  List<String> readingSyptomsFromIsymtomReader() {
		ReadSymptomDataFromFile filePathSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> listOfSymptoms = filePathSymptoms.GetSymptoms();
		return listOfSymptoms;


	}
	/**
	 * countingOccurenceOfSyptoms() is a method that gets the list of symptoms 
	 * then count the occurrence of each symptoms
	 * after that each symptoms is written to a .txt file.   
	 */
	public  void countingOccunrenceOfSyptoms() {


		try {
			HashMap<String, Integer> str = new HashMap<String, Integer>();
			for(String line : (readingSyptomsFromIsymtomReader()))

			{
				if (str.containsKey(line)) {
					int count = str.get(line) + 1;
					str.put(line, count);
				}else {
					str.put(line, 1);	
				}
			}

			FileWriter writer = new FileWriter(fileSorting.getCanonicalPath());
			for (Entry<String, Integer> entry : str.entrySet()) {
				writer.write(entry.getKey()+" = "+entry.getValue());
				writer.write("\r\n");
			}
			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Now the .txt file is read into a list for it to be arranged alphabetically 
	 * then a new .txt file is created. 
	 * and finally the arranged alphabetically string is written to the created file.
	 * an out put of result.txt
	 */
	public void sortingSyptomsAlphabetically() {
		try {
			BufferedReader reader = new BufferedReader (new FileReader(fileSorting.getCanonicalPath()));
			String line = reader.readLine();
			ArrayList<String> str = new ArrayList<>();
			while((line=reader.readLine())!=null){
				str.add(line);
			}
			reader.close();
			Collections.sort(str);
			File file = new File("result.txt");

			FileWriter writer = new FileWriter(file.getCanonicalPath());
			for(String s: str){
				writer.write(s);
				writer.write("\r\n");
			}
			writer.close();




		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


}