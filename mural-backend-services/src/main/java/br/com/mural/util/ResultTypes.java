/*
 * Pearson All Rights Reserved
 * Nelson Fernando da Silva Menetti - Developer 
 */
package br.com.mural.util;

/**
 * The Enum ResultTypes.
 */
public enum ResultTypes {

	/** The Success. */
	Success("Success"),
	
	/** The Fail. */
	Fail("Fail"),
	
	/** The Error. */
	Error("Error");
	
	/** The type. */
	private String type;
		
	/**
	 * Instantiates a new result types.
	 *
	 * @param type the type
	 */
	private ResultTypes (String type){
		this.type=type;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
		
}
