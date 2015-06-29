package com.lincoln.adams.baristamatic.controller.application;

import java.util.logging.Logger;

import com.lincoln.adams.baristamatic.controller.BaristaController;
import com.lincoln.adams.baristamatic.initialize.BaristaMaticInitializer;
import com.lincoln.adams.baristamatic.view.io.Input;
import com.lincoln.adams.baristamatic.view.io.Output;


/**
 * controls the Barista-Matic
 * @author Lincoln Adams
 *
 */
public class ApplicationController {
    private static final Logger log = Logger.getLogger(ApplicationController.class.toString());

	Input   in;
    Output  out;
	BaristaMaticInitializer init;
	BaristaController controller;

	public ApplicationController(Input in,Output out,
	                    BaristaMaticInitializer init){
	    this.in            = in;
	    this.out           = out;
	    this.init          = init;
	    controller                = new BaristaController(init.getMenu());
	}


	/**
	 * run the Barista-Matic
	 */
	public void run(){
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
	    this.in = in;
	}
}
