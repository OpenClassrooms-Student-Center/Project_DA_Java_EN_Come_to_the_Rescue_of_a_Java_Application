package impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import services.ISymptomReader;

/**
 * 
 * @author Sophie
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePathIn;
	
	/**
	 * 
	 * @param filePathIn a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filePathIn) {
		this.filePathIn = filePathIn;
	}
	
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
