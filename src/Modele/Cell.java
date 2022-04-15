/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author adamsayedabouljoud
 */
public class Cell extends Rectangle{
    private int size;
    private boolean state;
    private Color defaultColor = Color.WHITE;
    private Color aliveColor = Color.RED;
    
    //5tara3er carre, ela state ya alive ya dead( true or false), w3 anda taille bhes 10 azbat chi, 
    //iza alive lawna ahmar, iza dead abyad bas hl2 hateta azra2 la yen2acha3 bel test.
    public Cell(int size){
        super();
        
        this.size = size;
        this.setWidth(size);
        this.setHeight(size);
        
        if(state == true){
            this.setFill(aliveColor);
        }else if(state == false){
            this.setFill(defaultColor);
        }
        
        
    }
    
    public void setSize(int newN){
        this.size = newN;
    }
    
    public void setState(boolean newState){
        this.state = newState;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean getState(){
        return this.state;
    }
    
    public void changeColor(){
        if(this.state == true){
            this.setFill(aliveColor);
        }else{
            this.setFill(defaultColor);
        } 
    }
    
    public void naissance(){
		this.setState(true);
                this.changeColor();
	}
	
	public void deces(){
		this.setState(false);
                this.changeColor();
	}
    
}
