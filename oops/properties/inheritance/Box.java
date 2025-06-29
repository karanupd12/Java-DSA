package oops.properties.inheritance;

public class Box {
    double l;    //length of box
    double h;    //height
    double w;    //breadth

    public Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    //cube                              //if we only pass one side in argument, this will execute
    Box(double side){
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box() {                             //if nothing is passed in argument
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box (Box old){
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
    }

    public void Displayinfo(){
        System.out.println("Running the box");
    }
}
