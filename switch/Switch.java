import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter week day number=");
        int day=sc.nextInt();

        //this is a new way for writting switch statements
        switch (day){
            case 1 -> System.out.println("monday");
            case 2 -> System.out.println("tuesday");
            case 3 -> System.out.println("wednesday");
            case 4 -> System.out.println("thursday");
            case 5 -> System.out.println("friday");
            case 6 -> System.out.println("saturday");
            case 7 -> System.out.println("sunday");
            default -> System.out.println("wrong day entered");
        }
    }
}

/*old way for writting switch statement :-

switch (day) {
    case 1:
        sysoln("monday");
        break;
    
    case 2:
    .
    .
    .
    .
    case 7:
        sysoln("sunday");
        break;
    
    default:
        sysoln("wrong entry");
}

*/