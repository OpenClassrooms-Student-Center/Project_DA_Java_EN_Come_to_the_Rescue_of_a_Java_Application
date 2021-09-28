package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Interface de Comptage
 * 
 * @author didier
 *
 */
public interface Icomptage {

	public TreeMap<String, Integer> comptageSymptomsData(List<String> symptoms);

}
