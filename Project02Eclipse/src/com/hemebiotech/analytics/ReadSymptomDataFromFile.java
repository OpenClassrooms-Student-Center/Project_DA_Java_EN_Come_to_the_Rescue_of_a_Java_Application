package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;
	
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
	//Decorador que indica que se sobrescribe un método 
	@Override
	//void = vacio
	//metodo publico, devuelve una lista de cadenas
	public List<String> getSymptoms() {
		//Crear instancia de arraylist para almacenar los sintomas
		List<String> symptoms = new ArrayList<>();
		
		
		try (BufferedReader reader = new BufferedReader (new FileReader(filePath))){
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
