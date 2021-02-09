package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;;

public class WriteData implements ISymptomWriter {
		/**
		* create a Text file and edit it with the results of the Map mSympt.
		* @param Map<String,Integer>mSympt a Map created in SymptomsCount class
		* @return serialize Map entries in a text file.
		* @throws IOException
		*
		*/
		public String writedata (Map<String,Integer> mSympt) throws IOException  {



		try {
		FileWriter writer = new FileWriter ("C://Users/33671/Desktop/result.txt");
		BufferedWriter bw = new BufferedWriter (writer);
		//commence la sequence de la boucle pour une map
		for(Entry<String, Integer> entry : mSympt.entrySet()) {

		String key = entry.getKey();
		Integer value = entry.getValue();
		String line = key+"  : "+value+"\n";

		bw.write(line);
		}


		bw.close();
		writer.close();
		}catch (IOException e) {
		e.printStackTrace();
		}
		return "";


		}










}
