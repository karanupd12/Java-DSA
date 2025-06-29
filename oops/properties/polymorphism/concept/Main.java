
package oops.properties.polymorphism.concept;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        circle.area();
        square.area();
        triangle.area();
    }
}
