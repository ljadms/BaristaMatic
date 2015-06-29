package com.lincoln.adams.baristamatic.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lincoln.adams.baristamatic.initialize.BaristaMaticInitializer;
import com.lincoln.adams.baristamatic.test.BaristaMaticTest;
import com.lincoln.adams.baristamatic.controller.application.ApplicationController;
import com.lincoln.adams.baristamatic.view.io.CodeInput;
import com.lincoln.adams.baristamatic.view.io.CodeOutput;
import com.lincoln.adams.baristamatic.view.io.Input;
import com.lincoln.adams.baristamatic.view.io.Output;

public class ApplicationTest implements BaristaMaticTest{
    Input                   in;
    Output                  out;
    BaristaMaticInitializer init;
    StringBuilder           outTest;
    StringBuilder           result;

    ApplicationController   app;

    @Before
    public void setUp(){
        outTest         = new StringBuilder();
        result          = new StringBuilder(INITSTATUS);
        in              = new CodeInput(new char[][]{{'q'}});
        out             = new CodeOutput(outTest);

        init            = new BaristaMaticInitializer();
        app             = new ApplicationController(in,out,init);
    }

    /**
     * test for initial start up
     */
    @Test
    public void testInitialStartUp() {
        app.run();
        assertEquals(result.toString(),outTest.toString());
    }

    /**
     * test for ordering a coffee
     */
    @Test
    public void testOrderCoffee() {
        in  = new CodeInput(new char[][]{{'5'},{'q'}});
        app.setIn(in);
        app.run();
        System.out.println(outTest.toString());

        result.append(DRINKORDER);
        result.append(AFTERCOFFEE);
        assertEquals(result.toString(),outTest.toString());
    }

    /**
     * test for restock as first command
     */
    @Test
    public void testRestock() {
        in  = new CodeInput(new char[][]{{'r'},{'q'}});
        app.setIn(in);
        app.run();
        System.out.println(outTest.toString());

        result.append(INITSTATUS);
        assertEquals(result.toString(),outTest.toString());
    }

    /**
     * test for restock after ordering coffee
     */
    @Test
    public void testRestockAfterCoffee() {
        in  = new CodeInput(new char[][]{{'5'},{'r'},{'q'}});
        app.setIn(in);
        app.run();
        System.out.println(outTest.toString());

        result.append(DRINKORDER);
        result.append(AFTERCOFFEE);
        result.append(INITSTATUS);
        assertEquals(result.toString(),outTest.toString());
    }

    /**
     * test for illegal command
     */
    @Test
    public void testInvalidCommand() {
        in  = new CodeInput(new char[][]{{'z'},{'q'}});
        app.setIn(in);
        app.run();
        System.out.println(outTest.toString());

        result.append(INVALID);
        result.append(INITSTATUS);
        assertEquals(result.toString(),outTest.toString());
    }

}
