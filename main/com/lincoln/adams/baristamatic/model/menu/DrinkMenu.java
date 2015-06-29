package com.lincoln.adams.baristamatic.model.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.lincoln.adams.baristamatic.model.Ingredients;
import com.lincoln.adams.baristamatic.model.Vendable;


/**
 * Menu class for Barista-Matic
 * holds the available drinks and current ingredient inventory
 * @author Lincoln
 *
 */
public class DrinkMenu {
    private static final Logger log = Logger.getLogger(DrinkMenu.class.toString());
    
    private Map<Integer,Vendable> drinks;
    private Ingredients           inventory;
    private Ingredients           initialInventory;
    private int                   size;
    
    
    public DrinkMenu(Ingredients inventory){
        drinks             = new HashMap<Integer,Vendable>();
        this.inventory     = inventory;
        initialInventory   = inventory.clone();
        size               = 0;
    }
    
    /**
     * add a drink to the available menu items
     * @param number - the menu number to associate with the drink
     * @param drink - the drink to add
     */
    public void addDrink(int number,Vendable drink){
        size++;
        drinks.put(number,drink);
        
        log.fine(String.format("Drink added to Menu: %d: %s",number,drink.getName()));
    }
    
    /**
     * add a drink to the available menu items
     * @param drink - the drink to add
     */
    public void addDrink(Vendable drink){
        size++;
        drinks.put(size,drink);
        
        log.fine(String.format("Drink added to Menu: %d: %s",size,drink.getName()));
    }
    /**
     * tells if the given drink is in stock
     * (all the needed ingredients are available)
     * @param drinkNumber - order number of the drink to check
     * @return true if the drink is in stock, false if it is not
     */
    public boolean inStock(int drinkNumber){
        Vendable drink = drinks.get(drinkNumber);
        return inventory.ingredientsAvailable(drink.getIngredients());
    }
    
    /**
     * make a drink from the drinks in the menu
     * effects inventory accordingly
     * @param drinkNumber - menu number of the drink to make
     * @return message displaying drink name
     */
    public StringBuilder makeDrink(int drinkNumber){
        Vendable      drink  = drinks.get(drinkNumber);
        StringBuilder result = new StringBuilder(drink.getName()); 
        
        inventory.useIngredients(drink.getIngredients()); 
        log.fine(String.format("made drink: %s", drink.getName()));
        return result;
    }
    
    /**
     * gets the current status of the menu
     * @return message dictating current inventory and drinks available
     */
    public StringBuilder getStatus(){
        StringBuilder result = new StringBuilder("Inventory:\n");
        //get current inventory status
        for(int i = 0;i<inventory.length();i++){
            result.append(String.format("%s,%d\n",
                    Ingredients.NAMES[i],
                    inventory.getInventory()[i]));       
        }
        result.append("Menu:\n");
        //get current drink menu and availability
        for(int drink=1;drink<=size;drink++){
            Vendable current    = drinks.get(drink);
            
            current.setInStock(inStock(drink));
            
            result.append(String.format("%d,%s,$%3.2f,%s\n",
                     drink,current.getName(),
                     current.getPrice(),
                     current.inStock()));
        }  
        //truncate last newline
        result.deleteCharAt(result.lastIndexOf("\n"));
        return result;
    }
    
    /**
     * resets the inventory to the initial amounts
     */
    public void restock(){
        inventory = initialInventory.clone();
        
        log.fine("inventory restocked");
    }
    
    /**
     * 
     * @param drinkNumber - number of the drink to return
     * @return drink of given order number
     */
    public Vendable getDrink(int drinkNumber){
        return drinks.get(drinkNumber);
    }
    
    
    /**
     * @return size of the menu
     * menu items are sequential from 1
     */
    public int size(){
        return size;
    }

}
