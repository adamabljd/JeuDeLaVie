/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author adamsayedabouljoud
 */
public class Plateau extends GridPane{
    private Color backgroundColor = Color.BLACK;
    private Cell[][] plateauTab;
    private int size;
    private static boolean execution;
    
    
    public Plateau(int size, Cell c){
        super();
        
        this.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setVgap(3);
        this.setHgap(3);
        this.size = size;
        this.plateauTab = new Cell[size][size];
        this.setPadding(new Insets(3,3,3,3));
        
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                
                    plateauTab[i][j] = new Cell(10);
                    this.add(plateauTab[i][j], i, j);
            }
        }
        
        this.plateauTab[0][0].setOnMouseClicked(e -> {
			this.placeCell(0,0);
                        System.out.println("Clicked");
		});
        
        
    }
    
    public void execute(){
        if(!execution){
            //lancement animation
            System.out.println("Stop");
            execution = true;

        }else{
            //arrêt animation
            System.out.println("Start");
            execution = false;

        }
    }
    
    public boolean getExecute(){
        return this.execution;
    }
    
    public void placeCell(int x, int y){
        if(!this.getExecute()){
                if(this.getCellFromPlateau(x, y).getState())
                        this.getCellFromPlateau(x, y).deces();
                else
                        this.getCellFromPlateau(x, y).naissance();
        }
    }
    
    public Cell getCellFromPlateau(int x , int y){
        return this.plateauTab[x][y];
    }
}
