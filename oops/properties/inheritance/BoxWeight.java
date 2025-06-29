//Boxweight is a child class and Box is a parent class so to inherit its all properties we use 'extends' keyword
//super class - if order of inheritance = [A >>> B >>> C] then A is the superclass of B abd B is the superclass of C

package oops.properties.inheritance;

//Single Inheritance
public class BoxWeight extends Box{
    double weight;

    public BoxWeight(){
        this.weight = -1;
    }

    BoxWeight (BoxWeight other){
        super(other);
        weight = other.weight;
    }

    BoxWeight(double side , double weight){
        super(side);
        this.weight = weight;
    }

    public BoxWeight(double l, double h, double w, double weight) {  //constructor of child class which has inherited the properties of l , h , w from its parent class
        super(l, h, w); //call the parent class constructor //used to initialize values present in parent class
        this.weight = weight;
    }
}
