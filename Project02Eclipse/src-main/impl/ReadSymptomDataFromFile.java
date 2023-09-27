package impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import services.ISymptomReader;


public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePathIn;
	
	public ReadSymptomDataFromFile (String filePathIn) {
		this.filePathIn = filePathIn;
	}
	/**
	 * Method that extracts symptoms data from a file and returns all the symptoms in a List of String.
	 * @return a List of String filled with all symptoms obtained from the data source (duplicates are possible/probable)
	 * @return an empty List if no data is available
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	@Override
	public List<String> getSymptoms() throws IOException, FileNotFoundException {

		List<String> listSymptomsString = new ArrayList<String>();
		
		if (filePathIn != null) {
			
				FileReader freader = new FileReader(this.filePathIn);
				BufferedReader breader = new BufferedReader(freader);

				String line = breader.readLine();
				
				while (line != null) {
					listSymptomsString.add(line);
					line = breader.readLine();
				}
				freader.close();
				breader.close();
				
		}		
		return listSymptomsString;
	}

}
