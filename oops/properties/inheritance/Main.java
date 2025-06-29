//order of inheritance : Box >>> BoxWeight >>> BoxPrice
package oops.properties.inheritance;

public class Main {
    public static void main(String[] args) {
//        Box box1 = new Box(4,8,9);
//        System.out.println(box1.l + " " + box1.h + " " + box1.w);                  //4.0 8.0 9.0
//
//        Box box2 = new Box(4);
//        System.out.println(box2.l + " " + box2.h + " " + box2.w);                  //4.0 4.0 4.0
//
//        Box box3 = new Box();
//        System.out.println(box3.l + " " + box3.h + " " + box3.w);                  //-1.0 -1.0 -1.0
//
//        Box box4 = new Box(box1);
//        System.out.println(box4.l + " " + box4.h + " " + box4.w);                  //4.0 8.0 9.0

        BoxWeight box5 = new BoxWeight();
        System.out.println(box5.weight);                                             //-1

        BoxWeight box6 = new BoxWeight(2,3,4,8);
        System.out.println(box6.l + " " + box6.weight);                               //2.0 8.0

        Box box7 = new BoxWeight (2,3,4,8);
        System.out.println(box7.w);

        //there are many variable in both parent and child classes
        //you are given access to variables that are in ref type i.e; BoxWeight
        //hence, you should have access to Weight variable
        //this also means, that the ones you are trying to access should be initialized
        //but here , when the object itself is of type parent class, how will you call the constructor of child class
        //this is why error
        // BoxWeight box8 = new Box(2,3,4);
        // System.out.println(box8);

        BoxPrice box8 = new BoxPrice(5 , 8  , 34);
        System.out.println(box8.cost);
    }
}
