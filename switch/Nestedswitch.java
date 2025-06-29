import java.util.Scanner;

public class Nestedswitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter employee id=");
        int empid = sc.nextInt();
        System.out.print("enter department=");
        String dep = sc.next();

        switch (empid) {
            case 1:
                System.out.println("karan Upadhyay");
                switch (dep) {
                    case "IT":
                        System.out.println("IT Department");
                        break;

                    case "Management":
                        System.out.println("Management department");
                        break;

                    default:
                        System.out.println("incorrect department entered");
                }
                break;

            case 2:
                System.out.println("ayush verma");
                switch (dep) {
                    case "IT":
                        System.out.println("IT Department");
                        break;

                    case "Management":
                        System.out.println("Management department");
                        break;

                    default:
                        System.out.println("incorrect department entered");
                }
                break;

            case 3:
                System.out.println("abhishek singh");
                switch (dep) {
                    case "IT":
                        System.out.println("IT Department");
                        break;

                    case "Management":
                        System.out.println("Management department");
                        break;

                    default:
                        System.out.println("incorrect department entered");
                }
                break;
            default:
                System.out.println("wrong id");
        }
    }
}
