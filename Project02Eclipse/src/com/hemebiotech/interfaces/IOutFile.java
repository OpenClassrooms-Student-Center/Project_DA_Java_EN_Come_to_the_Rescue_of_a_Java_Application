package com.hemebiotech.interfaces;

import java.util.TreeMap;

/**
 * Ecriture dans le fichier de sortie
 *
 */

public interface IOutFile {
	
	/**
	 * 
	 * @param Le tableau ordonné par ordre croissant contenant le nom et le nombre des symptômes
	 */
	public void editFinalFile(TreeMap<String,Integer> ordermap);

}
