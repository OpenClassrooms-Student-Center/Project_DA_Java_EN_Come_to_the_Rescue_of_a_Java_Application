package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {
	//void = vacio
	//metodo publico, devuelve una lista de cadenas
	public List<String> getSymptoms(String inputFile) {
		//Crear instancia de arraylist para almacenar los sintomas
		List<String> symptoms = new ArrayList<>();
		
		
		try (BufferedReader reader = new BufferedReader (new FileReader(inputFile))){
			String line = reader.readLine();
			
			while (line != null) {
				symptoms.add(line.trim().toLowerCase());
				line=reader.readLine();
			}
		}catch(IOException e){
            System.err.println("error"+e.getMessage());
        } 
		
		return symptoms;
	}

}
