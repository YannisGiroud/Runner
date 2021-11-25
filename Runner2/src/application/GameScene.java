package application;

import com.company.Main;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    //Attributes
    public Camera cam1;
    private static staticThing background_left;
    private static staticThing background_right;
    private hero hero;
    private foe foe;
    public static int floorLevel = 260;
    public boolean timestop=false;
    public static staticThing gameOverPane;
    public staticThing getGameOverPane() {
        return gameOverPane;
    }
    public void setGameOverPane(staticThing gameOverPane) {
        GameScene.gameOverPane = gameOverPane;
    }

    //Constructor
    public GameScene(Parent parent, double v, double v1, boolean b) {
        super(parent, v, v1, b);
        //Background
        this.background_left=new staticThing(0,0,"back.png");
        this.background_right=new staticThing(800,0,"back.png");
        this.setGameOverPane(new staticThing(1000,600,"background.png"));
        background_left.getImage1().setViewport(new Rectangle2D(0,0,background_left.getImage1().getFitHeight(),background_left.getImage1().getFitWidth()));
        background_right.getImage1().setViewport(new Rectangle2D(0,0,background_right.getImage1().getFitHeight(),background_right.getImage1().getFitWidth()));
        this.gameOverPane.getImage1().setViewport(new Rectangle2D(0,0,gameOverPane.getImage1().getFitHeight(),gameOverPane.getImage1().getFitWidth()));
        //Hero
        this.hero=new hero(50,floorLevel,"heros.png");

        //Ennemis
        this.foe=new foe();

        //Animation
        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long time) {
                foe.move();
                if(timestop==false) {
                    GameScene.update();
                }
                if ((hero.jumpOk == true)&(timestop==false)) {
                    hero.jump();
                }
                if ((hero.jumpOk == false)&(hero.getY()<floorLevel)) {
                    hero.fallOk=true;
                }
                if ((hero.fallOk == true)&(timestop==false)) {
                    hero.fall();
                }
                if (time - lastUpdate >= 80_000_000) {
                    if(timestop==false) {
                        hero.update();
                        foe.update();
                    }
                    lastUpdate = time;
                    System.out.println("FallOk : "+hero.fallOk);
                    System.out.println("JumpOk : "+hero.jumpOk);
                }
                if ((checkCollision()==true)) {
                    timestop= true;

                    gameOver();
                    this.stop();

                }

            }
        };
        timer.start();
        this.setOnKeyTyped( (event)->{
            //if (event.getCode()== KeyCode.ENTER ) {
            System.out.println("Jump");
            if (hero.getY()==floorLevel) {
                hero.jumpOk=true;
            }
        });
    }

    
    
    private static void update() {
        double x1 = background_left.getX();
        double x2 = background_right.getX();
        if(x2<=0){
            background_right.getImage1().setX(800);
            background_right.setX(800);
            background_left.getImage1().setX(0);
            background_left.setX(0);
        }
        else {
            background_left.getImage1().setX(x1 - 1.5);
            background_left.setX(x1-1.5);
            background_right.getImage1().setX(x2 - 1.5);
            background_right.setX(x2-1.5);
        }
    }

    public boolean checkCollision(){
        if((hero.getX()+60>foe.getX())&(hero.getX()<foe.getX()+60)&(hero.getY()+50>foe.getY())&(hero.getY()<foe.getY()+100)){
            return true;
        }
        else {
            return false;
        }
    }

    public void gameOver() {
        System.out.println("GameOver");
        gameOverPane.getImage1().setX(0);
        gameOverPane.getImage1().setY(100);
        gameOverPane.setX(200);
    }

    //Getters
    public static staticThing getBackground_left(){return background_left;}
    public static staticThing getBackground_right(){return background_right;}
    public hero getHero(){return hero;}
    public foe getFoe(){return foe;}



}
