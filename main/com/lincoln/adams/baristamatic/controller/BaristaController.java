package com.lincoln.adams.baristamatic.controller;

import java.util.logging.Logger;

import com.lincoln.adams.baristamatic.model.menu.DrinkMenu;


/**
 * controller for Barista-Matic
 * @author Lincoln
 *
 */
public class BaristaController {
    private static final Logger log = Logger.getLogger(BaristaController.class.toString());
    
    private DrinkMenu       menu;
    private boolean         inventoryChanged;
    private boolean         running;
    private StringBuilder   lastStatus;

    public BaristaController(DrinkMenu menu){
        this.menu        = menu;
        lastStatus       = menu.getStatus();
        running          = true;
        inventoryChanged = false;
    }
    /**
     * get the current barista-matic status
     * @return the current status (inventory and menu)
     */
    public String status(){
        if(inventoryChanged){
            lastStatus = menu.getStatus();
        }
        return lastStatus.toString();
    }
    
    /**
     * parse commands and act accordingly
     * @param command - command to parse
     * @return String to display as result of action taken
     */
    public String parseCommand(char[] command){
        if(command == null){
            return null;
        }
        //if command is 0-9
        else if((int)command[0] > 48 && (int)command[0] < 58){
            return orderDrink(command);
        }
        else if(command.length > 1){
            return invalidCommand(command);
        }
        
        switch(command[0]){
            case 'r': return restock();
            case 'R': return restock();
            case 'q': return quit();
            case 'Q': return quit();
            default : return invalidCommand(command);
        }
    }
    
    /**
     * tells if the controller is running
     * @return - true if the controller is running
     */
    public boolean isRunning(){
        return running;
    }
    
    private String invalidCommand(char[] command){
        log.fine("command is invalid");
        inventoryChanged = false;
        StringBuilder message = new StringBuilder("Invalid selection: ");
        return message.append(command).toString();
    }
    
    private String restock(){
        log.fine("command is for restock");
        menu.restock();
        inventoryChanged = true;
        return "";
    }
    
    private String quit(){
        log.fine("command is for quit");
        running = false;
        return "";
    }
    
    private String orderDrink(char[] command){
        //if the menu has less than 10 items and the given
        //command is longer than 1 character, it is invalid
        if(menu.size()<10 && command.length > 1){
            return invalidCommand(command);
            
        }else if(command.length == 1){
            int commandOrder = ((int) command[0]) - 48;
            if(commandOrder<=menu.size()){           
                return orderDrink(commandOrder);
            }
            
        }else if(menu.size()>=10 && command.length >1){
            
            for(char c:command){
                //if char is not a number
                if((int)c<48 || (int)c>57){
                    return invalidCommand(command);
                }
            }
            int commandOrder = Integer.valueOf(String.valueOf(command));
            return orderDrink(commandOrder);
        }
        
        return invalidCommand(command);
    }
    
    private String orderDrink(int commandOrder){
        log.fine("command is drink a order");
        StringBuilder message = new StringBuilder();
        if(menu.inStock(commandOrder)){
            inventoryChanged = true;
            message.append("Dispensing: ");
            return message.append(menu.makeDrink(commandOrder)).toString();
        }else{
            inventoryChanged = false;
            message.append("Out of stock: ");
            return message.append(menu.getDrink(commandOrder).getName()).toString();
        }
    }
    
}

