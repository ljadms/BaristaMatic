package com.lincoln.adams.baristamatic.test;

import com.lincoln.adams.baristamatic.model.Ingredients;

/**
 * holds testing constants
 * @author Lincoln Adams
 *
 */
public interface BaristaMaticTest {
    public static final Ingredients     STARTINGMENUINVENTORY    = new Ingredients(new int[]{
                                                                        10,10,10,
                                                                        10,10,10,
                                                                        10,10,10});
    
    public static final String[]        STARTINGDRINKNAMES       = new String[]{
                                                                        "Caffe Americano",
                                                                        "Caffe Latte",
                                                                        "Caffe Mocha",
                                                                        "Cappuccino",
                                                                        "Coffee",
                                                                        "Decaf Coffee"};
    
    
    
    public static final int[][]         STARTINGDRINKINGREDIENTS = new int[][]{// cocoa,coffee,cream,decaf,espr,FMilk,SMilk,sugar,WhipCream
                                                                        new int[]{0,    0,     0,    0,    3,   0,    0,    0,    0},
                                                                        new int[]{0,    0,     0,    0,    2,   0,    1,    0,    0},
                                                                        new int[]{1,    0,     0,    0,    1,   0,    1,    0,    1},
                                                                        new int[]{0,    0,     0,    0,    2,   1,    1,    0,    0},
                                                                        new int[]{0,    3,     1,    0,    0,   0,    0,    1,    0},
                                                                        new int[]{0,    0,     1,    3,    0,   0,    0,    1,    0}
                                                                        };
    
    public static final String          INITSTATUS = "Inventory:\n" +
                                                    "Cocoa,10\n" +
                                                    "Coffee,10\n" +
                                                    "Cream,10\n" +
                                                    "Decaf Coffee,10\n" +
                                                    "Espresso,10\n" +
                                                    "Foamed Milk,10\n" +
                                                    "Steamed Milk,10\n" +
                                                    "Sugar,10\n" +
                                                    "Whipped Cream,10\n" +
                                                    "Menu:\n" +
                                                    "1,Caffe Americano,$3.30,true\n"+
                                                    "2,Caffe Latte,$2.55,true\n"+
                                                    "3,Caffe Mocha,$3.35,true\n"+
                                                    "4,Cappuccino,$2.90,true\n"+
                                                    "5,Coffee,$2.75,true\n"+
                                                    "6,Decaf Coffee,$2.75,true";
    
    public static final String          AFTERCOFFEE = "Inventory:\n" +
                                                    "Cocoa,10\n" +
                                                    "Coffee,7\n" +
                                                    "Cream,9\n" +
                                                    "Decaf Coffee,10\n" +
                                                    "Espresso,10\n" +
                                                    "Foamed Milk,10\n" +
                                                    "Steamed Milk,10\n" +
                                                    "Sugar,9\n" +
                                                    "Whipped Cream,10\n" +
                                                    "Menu:\n" +
                                                    "1,Caffe Americano,$3.30,true\n"+
                                                    "2,Caffe Latte,$2.55,true\n"+
                                                    "3,Caffe Mocha,$3.35,true\n"+
                                                    "4,Cappuccino,$2.90,true\n"+
                                                    "5,Coffee,$2.75,true\n"+
                                                    "6,Decaf Coffee,$2.75,true";
                                            
    public static final String          DRINKORDER = "Dispensing: Coffee";
    public static final String          OUTOFSTOCK = "Out of stock: Coffee";
    public static final String          INVALID    = "Invalid selection: z";
    
}
