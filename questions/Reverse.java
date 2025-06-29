package questions;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number=");
        int num = sc.nextInt();
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            num /= 10;
            ans = ans * 10 + rem;
        }
        System.out.println("reverse is = " + ans);
    }
}

/*  EXAMPLE : If number is 56789 then 56789 % 10= 9(remainder) so,
/ans=9(initially) now 6578 % 10 = 8 so, ans=ans*10 + rem i.e; ans = 9*10 +8
 =98 again ans = 98*10 +7 =987 .......ans = 9876*10 +5=98765(reversed)*/