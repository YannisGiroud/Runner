package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class animatedThing {
    //Attributes
    private double x;
    private double y;
    private ImageView image;
    private int state;
    public int index;
    private static int frame_rate;
    private int index_max=5;
    private static int size_x;
    private static int size_y;
    private static int offset;
    public boolean jumpOk;
    public boolean fallOk;
    public int jumpIndex;
    public int fallIndex;

    //Constructor
    public animatedThing(double x,double y,String fileName){
        this.index = 0;
        Image image1 = new Image("\\image\\"+fileName);
        this.image = new ImageView(image1);
        this.image.setX(x);
        this.image.setY(y);
        this.image.setViewport(new Rectangle2D(index*75,0,75,100));
        this.x=x;
        this.y=y;
    }

    //Methods
    public ImageView getImage(){return image;}
    public int getIndex(){return index;}
    public void setIndex(int index) {
        this.index = index;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }
    public double getY(){return y;}
    public void setY(double y){this.y=y;}

    /*public void update(long time) {
            index = getIndex();
            if (index == 5) {
                setIndex(0);
            } else {
                setIndex(index + 1);
            }
            x = getX();
            getImage().setViewport(new Rectangle2D(index * 85, 0, 80, 100));
    }*/

}
