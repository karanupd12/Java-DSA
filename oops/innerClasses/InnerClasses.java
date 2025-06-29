package oops.innerClasses;

//classes within a class are known as inner classes
//outer classes cannot be static - it will giver error
//only inner classes can be static

class Parent{
    int age;
    public void showAge(){
        System.out.println("age of Parent is " + age);
    }

    class Child{
        int age;
        public void showAge(){
            System.out.println("age of child is " + age);
        }
    }
}

class InnerClasses {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.age = 40;
        parent.showAge();

        Parent.Child child = parent.new Child();
        child.age = 10;
        child.showAge();
    }
}
