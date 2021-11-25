package application;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;

import java.util.Timer;

public class hero extends animatedThing{

    public hero(double x, double y, String fileName) {
        super(x, y, fileName);
    }


    /*public void jump() {
        AnimationTimer timer1 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                hero.this.getImage().setViewport(new Rectangle2D(0, 165, 75, 100));
                double y = hero.this.getY();
                hero.this.setY(y - 2);
                hero.this.getImage().setY(y - 2);
                if (y < 100) {
                    this.stop();
                }
            }
        };
        AnimationTimer timer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                hero.this.getImage().setViewport(new Rectangle2D(85, 165, 75, 100));
                double y = hero.this.getY();
                hero.this.setY(y + 5);
                hero.this.getImage().setY(y + 5);
                if (y > 250) {
                    this.stop();
                    hero.this.setY(250);
                    hero.this.getImage().setY(250);
                    return;
                }
            }
        };
        timer1.start();
        timer2.start();
        }*/
    public void update() {
        index = getIndex();
        if (index == 5) {
            setIndex(0);
        } else {
            setIndex(index + 1);
        }

        if ((this.jumpOk == false) & (this.fallOk == false)) {
            getImage().setViewport(new Rectangle2D(index * 85, 0, 80, 100));
        }
        if ((this.jumpOk == true)) {
            getImage().setViewport(new Rectangle2D(0, 165, 75, 100));
        }

        if ((this.fallOk == true)) {
            getImage().setViewport(new Rectangle2D(85, 165, 75, 100));
        }
    }
    public void jump() {
        if (this.jumpIndex <= 60) {
            this.getImage().setY(getY() - 6 + (jumpIndex * 0.1));
            this.setY(getY() - 6 + (jumpIndex * 0.1));
            jumpIndex = jumpIndex + 1;
        }

        if (this.jumpIndex == 60) {
            jumpIndex = 0;
            this.jumpOk = false;
            this.fallOk = true;
        }
    }
    public void fall() {

        if (this.getY() < GameScene.floorLevel) {
            fallIndex = fallIndex + 1;
            this.getImage().setY(getY() + (fallIndex * 0.1));
            this.setY(getY() + (fallIndex * 0.1));
            fallIndex = fallIndex + 1;
        }

        if (this.getY() >= GameScene.floorLevel) {
            this.setY(GameScene.floorLevel);
            this.fallIndex = 0;
            this.fallOk = false;
        }
    }
    }

