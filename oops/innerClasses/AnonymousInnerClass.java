package oops.innerClasses;


class A{
    public void show(){
        System.out.println("In class A");
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        A a = new A(){
            public void show(){                        //this is called anonymous inner class as we are creating this on fly
                System.out.println("In new class");
            }
        };

        a.show();
    }
}
