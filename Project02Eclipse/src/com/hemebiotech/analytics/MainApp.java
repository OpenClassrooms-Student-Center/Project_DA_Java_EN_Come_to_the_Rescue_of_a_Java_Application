package com.hemebiotech.analytics;

public class MainApp {

	public static void main(String[] args) {
		
		//java -jar MainApp.jar filename="FILE" "" fileIn="" fileOut=""
 		AbstractSymptomAnalyzerApplication app = SymptomAnalyserAppBuilder.createApplication( "FILE" , args);
		
		if( app != null ) {
			app.run();
		}
		
	}

}
