package com.lincoln.adams.baristamatic.model;

/**
 * Ingredient class for Barista-Matic
 * used to store available ingredients, or needed ingredients
 * holds ingredient names and prices
 * 
 * @author Lincoln Adams
 *
 */
public class Ingredients{
    
    private int[]                inventory;
    public static final String[] NAMES    = {"Cocoa",
                                             "Coffee",
                                             "Cream",
                                             "Decaf Coffee",
                                             "Espresso",
                                             "Foamed Milk",
                                             "Steamed Milk",
                                             "Sugar",
                                             "Whipped Cream"};
    
    public static final double[] PRICES   = {.90d,
                                             .75d,
                                             .25d,
                                             .75d,
                                             1.10d,
                                             .35d,
                                             .35d,
                                             .25d,
                                             1.00d};
       
    public Ingredients(int[] inventory){
        this.inventory = inventory;
    }
    
    /**
     * if all the given ingredients are available, subtract them 
     * from the available inventory and return true,
     * otherwise return false
     * @param ingredients - ingredients needed
     * @return true if all needed ingredients are available and subtracted,
     *  otherwise false
     */
    public boolean useIngredients(Ingredients ingredients){
        int[] temp = inventory;
        for(int i=0;i<temp.length;i++){
            temp[i] -= ingredients.getInventory()[i];
            if(temp[i] < 0){
                return false;
            }
        }
        inventory = temp;
        return true;
    }

    /**
     * tells whether this ingredients object has the necessary ingredients
     * for the given ingredients
     * @param ingredients - ingredients needed
     * @return true if has all the needed ingredients
     */
    public boolean ingredientsAvailable(Ingredients ingredients) {
        int[] temp = inventory.clone();
        for(int i=0;i<temp.length;i++){
            temp[i] -= ingredients.getInventory()[i];
            if(temp[i] < 0){
                return false;
            }
        }
        return true;
    }
    
    /**
     * return a clone of this object
     */
    public Ingredients clone(){
        return new Ingredients(inventory.clone());
    }
    
    public int[] getInventory(){
        return inventory;
    }
    public void setInventory(int[] inventory){
        this.inventory = inventory;
    }
    
    public int length(){
        return inventory.length;
    }
}
