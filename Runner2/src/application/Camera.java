package application;

public class Camera {

    //Attributes
    private int pos_x;
    private int pos_y;

    //Constructor
    public Camera(int x,int y){
    }

    //Methods
    public int getPos_x(){return pos_x;}
    public int getPos_y(){return pos_y;}

    public void update(){return;}

    @Override
    public String toString(){
        return pos_x+", "+pos_y;
    }
}
