package oops.static_;

//this is a demo to show initialisation of static variable
public class StaticBlock {
    static int a = 4;
    static int b;

    //will only run once when the first object is created i.e; when the class is loaded for the first time
    static {
        System.out.println("i am in static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}
