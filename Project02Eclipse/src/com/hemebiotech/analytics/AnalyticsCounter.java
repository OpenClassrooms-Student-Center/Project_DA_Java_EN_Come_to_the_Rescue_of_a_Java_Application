package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile readerOk = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> listFromFile = readerOk.getSymptoms();
		
		CountAndOrderSymptoms counter = new CountAndOrderSymptoms();
		counter.processData(listFromFile);
		
	}



		
	
		//Compter et trier => faire une implémentation d'un interface (à mettre dans un autre fichier)
		/*setI(0);
		setHeadCount(0);
		Object line = null;
		while (line != null) {
			setI(getI() + 1);	// increment i
			//System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				setHeadCount(getHeadCount() + 1);
				//System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (((List<String>) line).contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		// fever = 12 */
		
		
/*		// next generate output
		//Ceci doit faire partie d'un implémentation (donc d'une autre classe)
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		AnalyticsCounter.i = i;
	}

	public static int getHeadCount() {
		return headCount;
	}

	public static void setHeadCount(int headCount) {
		AnalyticsCounter.headCount = headCount;
	} */
}


