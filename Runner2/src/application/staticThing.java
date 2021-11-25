package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    //Attributes
    private double x;
    private double y;
    private ImageView image1;

    //Constructor
    public staticThing(double x,double y,String fileName){
        Image image = new Image("\\image\\"+fileName);
        this.image1 = new ImageView(image);
        this.image1.setX(x);
        this.image1.setY(y);
        this.x=x;
        this.y=y;
    }



    //Methods
    public ImageView getImage1(){return image1;}

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }
}
