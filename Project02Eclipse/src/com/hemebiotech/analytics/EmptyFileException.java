package com.hemebiotech.analytics;

/**
 * @author Fatima
 * 
 *         Class that inherit from Exception class
 */
public class EmptyFileException extends Exception {

	/**
	 * Constructor that call constructor of Exception parent class with
	 * message(String)
	 */
	public EmptyFileException() {

		super("Empty File!");
	}
}
