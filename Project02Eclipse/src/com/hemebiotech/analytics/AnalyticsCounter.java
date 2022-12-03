package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {


	public List<String> readSymptom(ISymptomReader dataInput) {
		return dataInput.getSymptoms();

	}



public TreeMap<String,Integer> sortAndCount(ICountAndSort sortAndCount) {

return sortAndCount.countAndSort();

	}
// version mais pas optimisé ..
	public void saveResult(TreeMap<String, Integer> map) {

		try{
			FileWriter writer = new FileWriter("result.out");
			Set<String> keys = map.keySet(); //list of key
			for(String key: keys){
				writer.write(key + ":" + map.get(key) + "\n");
			}
			writer.close();


		}catch(IOException e){
			e.printStackTrace();
		}

	}

	/*public 	void saveResult(TreeMap<String,Integer> map){
		try {
			FileWriter writer = new FileWriter("result2.out");


			TreeMap map1  = sortAndCount(readSymptom(new ReadSymptomDataFromFile("Symptoms.txt")));

			




		} catch (IOException e){
			e.printStackTrace();
		}
	}*/
}
