package com.lincoln.adams.baristamatic.model;

/**
 * Model entity for drinks in Barista-Matic application
 * @author Lincoln Adams
 *
 */
public class Drink implements Vendable{

    private String       name;
    private Ingredients  ingredients;
    private double       price;
    private boolean       inStock;
    
    public Drink(String name,Ingredients ingredients){
        this.name        = name;
        this.ingredients = ingredients;
        price            = 0d;
        for(int i=0;i<ingredients.length();i++){
            price += (ingredients.getInventory()[i] * Ingredients.PRICES[i]);
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Ingredients getIngredients() {
        return ingredients;
    }
    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean inStock(){
        return inStock;
    }
    public void setInStock(boolean inStock){
        this.inStock = inStock;
    }
}
