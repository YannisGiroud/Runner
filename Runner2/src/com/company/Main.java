package com.company;


import application.GameScene;
import application.staticThing;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

            primaryStage.setTitle("Takoyaki's REVENGE II : Return of Poulpi");
            Group root = new Group();
            Pane pane = new Pane(root);
            GameScene theScene = new GameScene(pane, 800, 400,true);
            pane.getChildren().add(theScene.getBackground_left().getImage1());
            pane.getChildren().add(theScene.getBackground_right().getImage1());
            pane.getChildren().add(theScene.getHero().getImage());
            pane.getChildren().add(theScene.getFoe().getImage());
            primaryStage.setScene(theScene);
            primaryStage.show();
            }

        public static void main(String[] args) {
            launch(args);
            }
    }

