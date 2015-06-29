package com.lincoln.adams.baristamatic.view.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * Input implementation that utilizes the standard input
 * @author Lincoln Adams
 *
 */
public class StdInput implements Input {
    private static final Logger log = Logger.getLogger(StdInput.class.getName());

	private static       BufferedReader in;
	
	public StdInput(){
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	

	@Override
	public char[] getCommand() {
		try {
		    String command;
		    if( (command = in.readLine()) != null
		            && command.length()!=0){
		        log.fine(String.format("Command given: %s",command));
		        return command.toCharArray();
		    }else{
		        return null;
		    }
		} catch (IOException e) {
		    log.warning(e.toString());
			return null;
		}finally{
		    try {
                in.close();
            } catch (IOException e) {
                log.warning(e.toString());
            }
		}
	}

	@Override
	public boolean ready() {
		try {
			return in.ready();
		} catch (IOException e) {
		    log.warning(e.toString());
			return false;
		}
	}

}
