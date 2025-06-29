package oops.static_;

public class Main {
    public static void main(String[] args) {
        //i don't have to import the human class as its in the same package(staticexample)
        Human karan = new Human ("Karan Upadhyay" , 19 , 70000 , false);
        Human ajay = new Human ("Ajay Sharma" , 30 , 60000 , true);

        System.out.println(karan.name); //this means print karan's name //Karan Upadhyay
        System.out.println(ajay.salary); //60000

        //because the population is same for every human in this world - //2
        //static variable is always declared, accessed, and manipulated by class name (it can also be accessed by object name , but its not right convention)
        System.out.println(Human.population); //2
        //System.out.println(karan.population); //2
        //System.out.println(ajay.population);  //2
    }
}
