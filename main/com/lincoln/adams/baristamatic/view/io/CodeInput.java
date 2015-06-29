package com.lincoln.adams.baristamatic.view.io;

import java.util.logging.Logger;

/**
 * input class
 * utilizes in-code commands, allows for integration testing
 * cycles through given commands
 * @author Lincoln Adams
 *
 */
public class CodeInput implements Input {
    private static final Logger log = Logger.getLogger(CodeInput.class.toString());
    private char[][] commands;
    private int      currentCommand;
    private boolean  ready;
    
    public CodeInput(char[][] commands){
        this.commands  = commands;
        currentCommand = 0;
        ready          = true;
    }

    @Override
    public char[] getCommand() {  
        ready = false;
        if(currentCommand >= commands.length){
            log.warning("Input is out of commands, quiting application");
            return new char[]{'q'};
        }else{
            return commands[currentCommand++];
        }
    }

    @Override
    public boolean ready() {
        boolean temp = ready;
        ready = true;
        return temp;
    }

}
