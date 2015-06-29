package com.lincoln.adams.baristamatic.initialize;

import com.lincoln.adams.baristamatic.model.Drink;
import com.lincoln.adams.baristamatic.model.Ingredients;
import com.lincoln.adams.baristamatic.model.menu.DrinkMenu;


/**
 * Initializes drink menu and inventory for Barista-Matic
 * The available menu and initial ingredient inventory can be changed by
 *  changing the values here
 * @author Lincoln Adams
 *
 */
public class BaristaMaticInitializer {
    private DrinkMenu  menu;
    private Drink[]    drinks;
    
    private static final Ingredients STARTINGMENUINVENTORY    = 
            new Ingredients(new int[]{
                        10,10,10,
                        10,10,10,
                        10,10,10});
    
    private static final String[]    STARTINGDRINKNAMES       = 
            new String[]{
                        "Caffe Americano",
                        "Caffe Latte",
                        "Caffe Mocha",
                        "Cappuccino",
                        "Coffee",
                        "Decaf Coffee"};
    
                                                                                
                                                                             
    private static final int[][]     STARTINGDRINKINGREDIENTS =
            new int[][]{//    cocoa,coffee,cream,decaf,espr,fMilk,sMilk,sugar,WhipCream
                    new int[]{0,    0,     0,    0,    3,   0,    0,    0,    0},
                    new int[]{0,    0,     0,    0,    2,   0,    1,    0,    0},
                    new int[]{1,    0,     0,    0,    1,   0,    1,    0,    1},
                    new int[]{0,    0,     0,    0,    2,   1,    1,    0,    0},
                    new int[]{0,    3,     1,    0,    0,   0,    0,    1,    0},
                    new int[]{0,    0,     1,    3,    0,   0,    0,    1,    0}
                        };
          
    /**
     * initialize Barista-Matic with set values
     */
    public BaristaMaticInitializer(){
        setupDrinks();
        setupMenu();
    }
    
    /**
     * get menu
     * @return menu
     */
    public DrinkMenu getMenu(){
        return menu;
    }
    
    private void setupDrinks(){
        drinks      = new Drink[STARTINGDRINKNAMES.length];
        
        for(int i=0;i<STARTINGDRINKNAMES.length;i++){
            drinks[i] = new Drink(STARTINGDRINKNAMES[i],
                        new Ingredients(STARTINGDRINKINGREDIENTS[i]));
        }
    }
    private void setupMenu(){
        menu = new DrinkMenu(STARTINGMENUINVENTORY.clone()); 
        
        for(Drink drink: drinks){
            menu.addDrink(drink);
        }
    }
    
    

}
