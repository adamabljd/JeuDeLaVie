/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author adamsayedabouljoud
 */
public class Tray extends GridPane{
    private Color backgroundColor = Color.BLACK;
    private int n;
    private int size;
    private boolean[][] boolarr;
    Random random = new Random();
    private Cell[][] cellArr;
    
    public Tray(int size, int n){
        this.size = size;
        this.n = n;
        this.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        //this.setPrefSize(size, size);
        this.boolarr = new boolean[n][n];
        this.cellArr = new Cell[n][n];
        randomFillTray();
        
        
        this.setPadding(new Insets(10,10,10,10));
        this.setHgap(2);
        this.setVgap(2);
        
    }
    
    public void initTray(){
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.n; j++){
                this.boolarr[i][j] = false;
                Cell c = new Cell( 10); 
                this.cellArr[i][j] = c;
                this.add(cellArr[i][j], i, j);
            }
        }
    }
    
    public void randomFillTray(){
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.n; j++){
                this.boolarr[i][j] = random.nextBoolean();
                Cell c = new Cell( 10); 
                this.cellArr[i][j] = c;
                this.add(cellArr[i][j], i, j);
            }
        }
    }
    
    public void changeState(){
        for(int i = 0 ; i < this.n ; i++){
            for (int j = 0 ; j < this.n ; j++){

                    int voisins = 0;

                    if(boolarr[(i-1+n)%n][(j-1+n)%n] == true)
                            voisins++;

                    if(boolarr[i][(j-1+n)%n] == true)
                            voisins++;

                    if(boolarr[(i+1)%n][(j-1+n)%n] == true)
                            voisins++;

                    if(boolarr[(i+1)%n][j] == true)
                            voisins++;

                    if(boolarr[(i+1)%n][(j+1)%n] == true)
                            voisins++;

                    if(boolarr[i][(j+1)%n] == true)
                            voisins++;

                    if(boolarr[(i-1+n)%n][(j+1)%n] == true)
                            voisins++;

                    if(boolarr[(i-1+n)%n][j] == true)
                            voisins++;

                    if(boolarr[i][j] == true){
                            //conditions de décès:
                            if(voisins == 4 || voisins == 0 || voisins == 1){
                                    this.boolarr[i][j] = false;
                                    this.cellArr[i][j].setState(boolarr[i][j]);
//                                    System.out.println("Case: "+ i+ " " + j + " ALIVE " + voisins + "Deleted. ");
                                    
                            }else if(voisins == 3){
                                    this.boolarr[i][j] = true;
                                    this.cellArr[i][j].setState(boolarr[i][j]);
                                   // System.out.println("Case: "+ i+ " " + j + " ALIVE " + voisins + "Created. ");
                            }
                    }else{
                            //conditions de naissance:
                            if(voisins == 3){
                                    this.boolarr[i][j] = true;
                                    this.cellArr[i][j].setState(boolarr[i][j]);
                                   // System.out.println("Case: "+ i+ " " + j +" DEAD " + voisins + "Created. ");
                            }
                    }
            }
        }

//        boolean[][] future = new boolean[n][n];
//        
//        for (int l = 0; l < n; l++)
//        {
//            for (int m = 0; m < n; m++)
//            {
//                // finding no Of Neighbours that are alive
//                int aliveNeighbours = 0;
//                for (int i = -1; i <= 1; i++)
//                    for (int j = -1; j <= 1; j++)
//                      if ((l+i>=0 && l+i<n) && (m+j>=0 && m+j<n))
//                        if(this.boolarr[l + i][m + j] == true){
//                            aliveNeighbours++;
//                        }
//                System.out.println("Case: "+ l + " " + m + " " + aliveNeighbours);
//                
//                
//                // The cell needs to be subtracted from
//                // its neighbours as it was counted before
//                aliveNeighbours--;
// 
//                // Implementing the Rules of Life
// 
//                // Cell is lonely and dies
//                if ((boolarr[l][m] == true) && (aliveNeighbours < 2))
//                    future[l][m] = false;
// 
//                // Cell dies due to over population
//                else if ((boolarr[l][m] == false) && (aliveNeighbours > 3))
//                    future[l][m] = false;
// 
//                // A new cell is born
//                else if ((boolarr[l][m] == false) && (aliveNeighbours == 3))
//                    future[l][m] = true;
// 
//                // Remains the same
//                else
//                    future[l][m] = boolarr[l][m];
//            }
//        }
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                boolarr[i][j] = future[i][j];
//                Cell c = new Cell(boolarr[i][j], 10);
//                this.add(c, i, j);
//            }
//        }
    }
   
    
}
