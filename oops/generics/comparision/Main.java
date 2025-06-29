package oops.generics.comparision;

public class Main {
    public static void main(String[] args) {
        Student karan = new Student(1, 98.45f);
        Student rohit = new Student(2 , 85.89f);

//        if (karan.marks < rohit.marks){
//            System.out.println("rohit has higher marks than karan");
//        }
//        else{
//            System.out.println("Karan has higher marks than rohit");
//        }

        if (karan.compareTo(rohit) > 0){        //rohit = o  //karan marks - rohit marks >>> if +ve than karan has more marks and vice-versa
            System.out.println("Karan has more marks");
        }
    }
}
