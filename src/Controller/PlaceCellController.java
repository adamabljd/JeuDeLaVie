/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modele.Cell;
import Modele.Plateau;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 *
 * @author adamsayedabouljoud
 */
public class PlaceCellController {
    private Cell c;
    private Plateau p;
    
    public PlaceCellController(Cell c, Plateau p){
        this.c = c;
        this.p = p;
        
        this.c.setOnMouseClicked(e -> {
			//this.p.placeCell(c);
                        System.out.println("Clicked");
		});
        
        
    }

    
}
