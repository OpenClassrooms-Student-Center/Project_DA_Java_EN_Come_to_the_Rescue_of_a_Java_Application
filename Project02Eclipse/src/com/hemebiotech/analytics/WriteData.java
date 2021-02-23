package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;;

public class WriteData implements ISymptomWriter {
	/**
	 * create a Text file and edit it with the results of the Map mSympt.
	 * @param Map<String,Integer>mSympt a Map created in SymptomsCount class
	 * @throws IOException
	 */
	public Map<String,Integer> writeSymptomDataToFile (Map<String,Integer> mSympt)    {

		FileWriter writer  = null;
		BufferedWriter bw = null;

		try {
			writer = new FileWriter ("results.out");
			bw = new BufferedWriter (writer);

			for(Entry<String, Integer> entry : mSympt.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				String line = key+"  : "+value+"\n";
				bw.write(line);
			}

		}catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try{bw.close();
			writer.close();
			}catch (IOException e) {

			}
		}

		return mSympt;

	}
}











