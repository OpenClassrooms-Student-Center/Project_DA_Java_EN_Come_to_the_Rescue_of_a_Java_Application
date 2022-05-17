package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public final class ASymptomCounter {
		
	public static void main(String args[]) {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteResultToFile("result.out",reader.getSymptoms());
		CounterProgram program = new CounterProgram(reader,writer);
		program.start();	
	}
	
}

