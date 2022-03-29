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

	/**
	 * 
	 * Getter: Method that returns value of symptomList
	 *
	 * @return symptomList: TreeMap<String, Long> that contains list of symptoms and
	 *         numbers of occurrences
	 * 
	 */
	public TreeMap<String, Long> getSymptomList() {
		return symptomList;
	}

	/**
	 * 
	 * Setter: Method that sets value of symptomList
	 * 
	 * @param symptomList: TreeMap<String, Long> that contains list of symptoms and
	 *                     numbers of occurrences
	 *
	 */
	public void setSymptomList(TreeMap<String, Long> symptomList) {
		this.symptomList = symptomList;
	}

	/**
	 * 
	 * Getter: Method that returns value of filepath
	 *
	 * @return filepath: String that contain a file path where a result file will be
	 *         created
	 * 
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * 
	 * Setter: Method that sets value of filepath
	 * 
	 * @param filepath: String that contain a file path where a result file will be
	 *                  created
	 *
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 * @param treeMap:  TreeMap that contains list of symptoms and numbers of
	 *                  occurrences
	 * @param filepath: String that contain a file path where a result file will be
	 *                  created
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
	 *
	 */
	@Override
	public void generateOutputFile() {

		if (filepath != null && symptomList != null && !symptomList.isEmpty()) {
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
					result = result.concat("- " + entry.getKey() + ":" + entry.getValue() + "\n");
				}
				myWriter.write(result);
				myWriter.close();
				System.out.println("Write symptom data to file: Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("Write symptom data to file: An error occurred.");
				e.getMessage();
				e.printStackTrace();
			}
		} else if (filepath == null)
			System.out.println("Write symptom data to file: File path is null!");
		else if (symptomList.isEmpty())
			System.out.println("Write symptom data to file: List of symptoms is empty!");
		else if (symptomList == null)
			System.out.println("Write symptom data to file: List of symptoms is null!");
	}
}
