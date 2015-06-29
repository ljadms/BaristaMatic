package com.lincoln.adams.baristamatic.model;

/**
 * Interface that describers vendable objects
 * @author Lincoln Adams
 *
 */
public interface Vendable {
    
    /**
     * get Vendable's name
     * @return name of vendable object
     */
    public String getName();
    
    /**
     * set vendable's name
     * @param name 
     */
    public void setName(String name);
    
    /**
     * get vendable's ingredients
     * @return the ingredients required to vend object
     */
    public Ingredients getIngredients();
    
    /**
     * set vendable's ingredients
     * @param ingredients
     */
    public void setIngredients(Ingredients ingredients);
    
    /**
     * get price of vendable object
     * @return ordering price of vendable object
     */
    public double getPrice();
    
    /**
     * set the vendable's price
     * @param price
     */
    public void setPrice(double price);
    
    /**
     * 
     * @return the vendable object is in stock
     */
    public boolean inStock();
    
    /**
     * sets the vendable object's status
     * @param inStock true if the vendable object is in stock,
     *  false if it is not
     */
    public void setInStock(boolean inStock);

}
