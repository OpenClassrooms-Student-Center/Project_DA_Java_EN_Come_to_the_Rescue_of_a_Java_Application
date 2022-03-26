package com.hemebiotech.analytics;

/**
 *@author Fatima
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Simple brute force implementation Class that write symptom data to file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private TreeMap<String, Long> symptomList;
	private String filepath;

	public WriteSymptomDataToFile() {
	}

	public TreeMap<String, Long> getSymptomList() {
		return symptomList;
	}

	public void setSymptomList(TreeMap<String, Long> symptomList) {
		this.symptomList = symptomList;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Constructor
	 * 
	 * @param TreeMap that contains list of symptoms and their occurrences, String
	 *                that contain a file path where a file will be created
	 * 
	 */
	public WriteSymptomDataToFile(TreeMap<String, Long> treeMap, String filepath) {
		this.symptomList = treeMap;
		this.filepath = filepath;
	}

	/**
	 * Method that generate output file : create a new file in the file path, fill
	 * the file with symptoms and their occurrences
	 * 
	 * @exception generate IOException when file path is empty
	 * @return nothing
	 */
	@Override
	public void generateOutputFile() {

		if (filepath != null && !symptomList.isEmpty()) {
			try {
				File myObj = new File(filepath);
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}

				FileWriter myWriter = new FileWriter(filepath);
				String result = "";

				for (Entry<String, Long> entry : symptomList.entrySet()) {
					result = result.concat("*" + entry.getKey() + ":" + entry.getValue() + "\n");
				}
				myWriter.write(result);
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.getMessage();
				e.printStackTrace();
			}
		} else if (filepath == null)
			System.out.println("File path = null!");
		else if (symptomList.isEmpty())
			System.out.println("List of symptoms is empty!");
	}
}
