package com.lincoln.adams.baristamatic.view.io;

/**
 * Output implementation that utilizes the standard output
 * @author Lincoln Adams
 *
 */
public class StdOutput implements Output {

    @Override
    public void display(String message) {
        System.out.println(message);
    }

}
