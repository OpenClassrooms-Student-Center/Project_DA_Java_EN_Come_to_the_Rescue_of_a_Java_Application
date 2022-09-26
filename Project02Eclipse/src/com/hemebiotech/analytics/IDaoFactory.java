/**
 * 
 */
package com.hemebiotech.analytics;

/**
 * Interface Data Access Object Factory
 * 
 * Provides Data Access Object Interfaces
 * 
 * @see ISymptomDao
 * @see ISymptomCountDao
 * @author trimok
 *
 */
public interface IDaoFactory {
	/**
	 * @return ISymptomDao interface for Symptom DAO
	 */
	ISymptomDao getSymptomDao();

	/**
	 * @return ISymptomDao interface for SymptomCount DAO
	 */
	ISymptomCountDao getSymptomCountDao();
}
