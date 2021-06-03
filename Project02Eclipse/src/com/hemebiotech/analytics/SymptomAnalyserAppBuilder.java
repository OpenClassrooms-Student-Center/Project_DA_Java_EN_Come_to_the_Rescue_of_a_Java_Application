package com.hemebiotech.analytics;

import com.hemebiotech.analytics.analyser.SymptomAnalyser;
import com.hemebiotech.analytics.reader.SymptomFileReader;
import com.hemebiotech.analytics.writer.SymptomFileWriter;

public class SymptomAnalyserAppBuilder {

	
	public static AbstractSymptomAnalyzerApplication createApplication( String applicationType,  String[] args ) {
		
		AbstractSymptomAnalyzerApplication app = null;
		
		switch ( applicationType.toUpperCase() ) {
		
			case "FILE":
				
				String fileIn = args.length > 0 ? args[0] : SymptomFileReader.DEFAULT_FILENAME_IN;
				String fileOut = args.length > 1 ? args[1] : SymptomFileWriter.DEFAULT_FILENAME_OUT;
				
				app = new SymptomAnalyserApplication();
				
				app.setWriter(new SymptomFileWriter(fileOut));
				app.setReader(new SymptomFileReader(fileIn));
				app.setAnalyser( new SymptomAnalyser() );
				
			break;
			
			

			default:
			break;
		}
		
		return app;
	}
	
	
	
}
