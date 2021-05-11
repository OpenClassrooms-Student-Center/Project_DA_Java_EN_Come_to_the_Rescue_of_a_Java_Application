package com.hemebiotech.analytics;

import java.util.HashMap;

public class SymptomFileWriter implements ISymptomWriter {

	public static String DEFAULT_FILENAME_OUT = "result.out";
	
	private String filepath;
	
	public SymptomFileWriter( String filepath ) {
		this.filepath = filepath;
	}
	
	@Override
	public void export(HashMap<String, Integer> symptoms) {
		// TODO Auto-generated method stub
		
	}

	
	
}
