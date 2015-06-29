package com.lincoln.adams.baristamatic;
import com.lincoln.adams.baristamatic.controller.application.ApplicationController;
import com.lincoln.adams.baristamatic.initialize.BaristaMaticInitializer;
import com.lincoln.adams.baristamatic.view.io.Input;
import com.lincoln.adams.baristamatic.view.io.Output;
import com.lincoln.adams.baristamatic.view.io.StdInput;
import com.lincoln.adams.baristamatic.view.io.StdOutput;

/**
 * runs the Barista-Matic
 * @author lincoln.adams
 *
 */
public class Application {
    static ApplicationController    app;
    static Input                    in;
    static Output                   out;
    static BaristaMaticInitializer  init;


    public static void main(String[] args){
        in              = new StdInput();
        out             = new StdOutput();
        init            = new BaristaMaticInitializer();

        app             = new ApplicationController(in,out,init);
        app.run();
    }

}
