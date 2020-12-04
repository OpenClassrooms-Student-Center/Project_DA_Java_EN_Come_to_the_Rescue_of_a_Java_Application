package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	static File doc = new File ("Project02Eclipse/symptoms.txt");
	static List<String> list = new ArrayList<String>();
	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	
	
	public static void main(String[] args) throws IOException {
		Class1.readDoc(doc, list); // File.txt analysis
		Class2.calculOcc(list, map); // counts occurrences
		Class3.docOut(map); // sort in natural order and generate a file
	}
	
}
