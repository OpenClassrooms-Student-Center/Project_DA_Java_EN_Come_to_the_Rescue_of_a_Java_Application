
package com.hemebiotech.analytics;

/**
 * A File Data Access Object Factory
 * 
 * @see IDaoFactory
 * @see ISymptomDao
 * @see ISymptomCountDao
 * @author trimok
 *
 */
public class DaoFileFactory implements IDaoFactory {

	/**
	 * The singleton
	 */
	public static DaoFileFactory instance = new DaoFileFactory();

	/**
	 * @return the singleton instance
	 */
	public static DaoFileFactory getFactory() {
		return instance;
	}

	/**
	 * @return ISymptomDao interface for Symptom DAO
	 */
	public ISymptomDao getSymptomDao() {
		return new SymptomFileDao();
	}

	/**
	 * @return ISymptomDao interface for SymptomCount DAO
	 */
	public ISymptomCountDao getSymptomCountDao() {
		return new SymptomCountFileDao();
	}
}
