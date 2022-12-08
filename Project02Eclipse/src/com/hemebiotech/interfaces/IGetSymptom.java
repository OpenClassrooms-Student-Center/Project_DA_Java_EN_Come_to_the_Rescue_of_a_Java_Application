package com.hemebiotech.interfaces;

import java.util.List;
/**
 * 
 * Symptômes mis en List grâce à symptoms.txt
 *
 */

public interface IGetSymptom {
	
	/**
	 * 
	 * @return la liste des symptômes dans une List<String>
	 */
	public List<String> GetSymptoms();

}
