package com.lincoln.adams.baristamatic.view.io;

/**
 * output class
 * puts output into StringBuilder to be accessed outside the class
 * @author Lincoln Adams
 *
 */
public class CodeOutput implements Output {
    private StringBuilder out;
    
    public CodeOutput(StringBuilder out){
        this.out = out;
    }

    @Override
    public void display(String message) {
        out.append(message);

    }

}
