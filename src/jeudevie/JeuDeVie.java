/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudevie;

import Modele.Cell;
import Modele.Tray;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author adamsayedabouljoud
 */
public class JeuDeVie extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Cell c= new Cell(false, 5);
        Tray t = new Tray(200, 3);
        Button  b = new Button();
        b.addEventHandler(ActionEvent.ANY, (ActionEvent e) -> {
            t.changeState();
            });
        
        StackPane root = new StackPane();
        root.getChildren().addAll(t, b);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
