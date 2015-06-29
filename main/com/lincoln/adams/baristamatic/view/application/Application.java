package com.lincoln.adams.baristamatic.view.application;

import java.io.IOException;
import java.util.logging.Logger;

import com.lincoln.adams.baristamatic.controller.BaristaController;
import com.lincoln.adams.baristamatic.initialize.BaristaMaticInitializer;
import com.lincoln.adams.baristamatic.view.io.Input;
import com.lincoln.adams.baristamatic.view.io.Output;
import com.lincoln.adams.baristamatic.view.io.StdInput;
import com.lincoln.adams.baristamatic.view.io.StdOutput;


/**
 * runs the Barista-Matic
 * @author Lincoln Adams
 *
 */
public class Application {
    private static final Logger log = Logger.getLogger(Application.class.toString());
    
	static Input                   in;
	static Output                  out;
	static BaristaMaticInitializer init;
	static BaristaController       controller;
	
	public Application(Input in,Output out,
	                    BaristaMaticInitializer init){
	    Application.in            = in;
	    Application.out           = out;
	    Application.init          = init;
	    controller                = new BaristaController(init.getMenu());
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	    in              = new StdInput();
	    out             = new StdOutput();
	    init            = new BaristaMaticInitializer();
	    
	    @SuppressWarnings("unused")  // sets input and output to use
        Application app = new Application(in,out,init);
		
		run();
	}
	
	
	/**
	 * run the Barista-Matic 
	 */
	public static void run(){    
	    log.fine("starting application");
	    
        char[] command = null;
        
        out.display(controller.status());
        //running loop
        while(controller.isRunning()){
            if(command != null){
                command = null;
            }
            while(in.ready()){
                    command = in.getCommand();
            }
            if(command != null){
                out.display(controller.parseCommand(command));
                if(controller.isRunning()){
                    out.display(controller.status());
                }
            }
        }
        log.fine("application finished running");
	}
	
	public void setIn(Input in){
	    Application.in = in;
	}
}
