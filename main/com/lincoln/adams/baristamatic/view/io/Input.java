package com.lincoln.adams.baristamatic.view.io;

/**
 * Input Facade for Barista-Matic application
 * @author Lincoln Adams
 *
 */
public interface Input {
	
	/**
	 * Get the next command from the input source
	 * @return the next command or null if no present commands
	 */
	public char[] getCommand();
	
	/**
	 * Tells whether the input is ready to be read.
	 * @return true if the input is ready
	 */
	public boolean ready();

}
