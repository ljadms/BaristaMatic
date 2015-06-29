package com.lincoln.adams.baristamatic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lincoln.adams.baristamatic.model.Drink;
import com.lincoln.adams.baristamatic.model.Ingredients;
import com.lincoln.adams.baristamatic.model.menu.DrinkMenu;

/**
 * Test of the menu class
 * @author Lincoln Adams
 *
 */
public class MenuTest {
    private DrinkMenu        menu;
    private Drink       drink;
    
    private final Ingredients INVENTORY         = new Ingredients(new int[]{
                                                                   10,10,10,
                                                                   10,10,10,
                                                                   10,10,10});
    private final Ingredients EMPTYINVENTORY    = new Ingredients(new int[]{
                                                                   0,0,0,
                                                                   0,0,0,
                                                                   0,0,0});
    private final Ingredients DRINKINGREDIENTS  = new Ingredients(new int[]{
                                                                   1,1,0,
                                                                   0,0,0,
                                                                   0,0,0});
    
    private final String TESTSTATUS             = "Inventory:\n" +
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
                		                          "1,test drink,$1.65,true";
    
    private final String AFTERDRINK             = "Inventory:\n" +
                                                "Cocoa,9\n" +
                                                "Coffee,9\n" +
                                                "Cream,10\n" +
                                                "Decaf Coffee,10\n" +
                                                "Espresso,10\n" +
                                                "Foamed Milk,10\n" +
                                                "Steamed Milk,10\n" +
                                                "Sugar,10\n" +
                                                "Whipped Cream,10\n" +
                                                "Menu:\n" +
                                                "1,test drink,$1.65,true";
                                
    @Before
    public void setup(){
        menu             = new DrinkMenu(INVENTORY);     
        drink            = new Drink("test drink",DRINKINGREDIENTS);
        menu.addDrink(drink);
    }
    
    @After
    public void tearDown(){
        menu  = null;
        drink = null;
    }

    /**
     * test for getStatus()
     * expects message of current inventory and drinks
     */
    @Test
    public void testGetStatus() {
        String status = menu.getStatus().toString();
        
        assertEquals(TESTSTATUS,status);
    }
    
    /**
     * test for getStatus()
     * expects message of current inventory and drinks
     */
    @Test
    public void testGetStatus_drinkDepleted() {
        menu.makeDrink(1);
        String status = menu.getStatus().toString();
        
        assertEquals(AFTERDRINK,status);
    }
    
    /**
     * test for makeDrink() - all needed ingredients are available
     * expects true
     */
    @Test
    public void testMakeDrink_ingredientsAvailable(){
        StringBuilder drinkMade = menu.makeDrink(1);
        
        assertEquals("test drink",drinkMade.toString());
    }
    
    /**
     * test for inStock() - all ingredients are available
     * expects true
     */
    @Test
    public void testInstock_ingredientsAvailable(){
        boolean test = menu.inStock(1);
        
        assertTrue(test);
    }
    
    /**
     * test for inStock() - all ingredients are not available
     * expects false
     */
    @Test
    public void testInstock_ingredientsNotAvailable(){
        menu =  new DrinkMenu(EMPTYINVENTORY);
        menu.addDrink(drink);
        
        boolean test = menu.inStock(1);

        assertFalse(test);
    }

}
