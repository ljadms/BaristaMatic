package com.lincoln.adams.baristamatic.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lincoln.adams.baristamatic.controller.BaristaController;
import com.lincoln.adams.baristamatic.model.Drink;
import com.lincoln.adams.baristamatic.model.Ingredients;
import com.lincoln.adams.baristamatic.model.menu.DrinkMenu;

public class BaristaControllerTest implements BaristaMaticTest{
    DrinkMenu               menu;
    BaristaController       barista;
    Drink[]                 drinks; 

    @Before
    public void setUp(){ 
        menu    = new DrinkMenu(STARTINGMENUINVENTORY.clone());
        setupDrinks();
        for(Drink d:drinks){
            menu.addDrink(d);
        }
        barista = new BaristaController(menu);
        
    }
    
    private void setupDrinks(){
        drinks = new Drink[STARTINGDRINKNAMES.length];
        for(int i=0;i<STARTINGDRINKNAMES.length;i++){
            drinks[i] = new Drink(STARTINGDRINKNAMES[i],
                                  new Ingredients(STARTINGDRINKINGREDIENTS[i]));
        }
    }
    
    @After
    public void tearDown(){
        System.out.println(menu.getStatus());
        menu        = null;
        barista     = null;
    }

    /**
     * test for the initial status message
     */
    @Test
    public void testParseCommand_startUp() {
        System.out.println("startup:");
      String message = barista.status();
      
      assertEquals(INITSTATUS,message);
    }
    
    /**
     * test for ordering a drink that is in stock
     * in this case, expects coffee to be drink 5
     */
    @Test
    public void testParseCommand_drinkOrder() {
        System.out.println("drinkOrder:");
      String message = barista.parseCommand(new char[]{'5'});
      
      assertEquals(DRINKORDER,message);
    }
    
    /**
     * test for odering a drink that is out of stock
     * in this case, expects coffee to be drink 5
     */
    @Test
    public void testParseCommand_drinkOrderOutOfStock() {
        System.out.println("outOfStock:");
      char[] command = new char[]{'5'};
      //use up coffee inventory
      barista.parseCommand(command);
      barista.parseCommand(command);
      barista.parseCommand(command);
      
      String message = barista.parseCommand(command);
      
      assertEquals(OUTOFSTOCK,message);
    }
    
    /**
     * test for an invalid command
     */
    @Test
    public void testParseCommand_invalidCommand() {
        System.out.println("invalid:");
      String message = barista.parseCommand(new char[]{'z'});
      
      assertEquals(INVALID,message);
    }

}
