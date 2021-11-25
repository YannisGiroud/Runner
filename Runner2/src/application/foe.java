package application;

import javafx.geometry.Rectangle2D;

public class foe extends animatedThing{
    public foe(){
        super(800,290,"poulpi.png");
    }

    public void update(){
        getImage().setViewport(new Rectangle2D( 0, 0, 100, 100));
        double y =getY();
    if(y==290){
        getImage().setY(288);
        setY(288);
    }
    else {
        getImage().setY(290);
        setY(290);
    }
    }

    public void move(){
        double x = getX();
        if (x<=-100){
            setX(800);
            this.getImage().setX(800);
        }
        else{
            setX(x-2);
            this.getImage().setX(x-2);
        }
    }
}
