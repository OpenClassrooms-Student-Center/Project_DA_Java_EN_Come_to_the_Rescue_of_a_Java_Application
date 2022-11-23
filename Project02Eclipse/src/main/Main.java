package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import util.AnalyticsCounter;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String filePathIn = "./fichiers/symptoms.txt";
		String filePathOut = "./fichiers/result.out";
				
		AnalyticsCounter analysis = new AnalyticsCounter(filePathIn, filePathOut);
		analysis.readFile();
		analysis.analyseData();
		analysis.writeFile();

	}

}
