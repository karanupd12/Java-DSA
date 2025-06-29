
package recursion.questions;

public class Patterns {
    public static void main(String[] args) {

        /*triangle1 using iteration(using loop)
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        */

        // triangle 1  using recursion (converting iteration to recursion)
        triangle1(5, 0);

        System.out.println();

        triangle2(0,0);
 

    }

/*  triangle1
* * * * * 
* * * * 
* * * 
* * 
* 
 */
    static void triangle1(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {                    //filling up columns of a row
            System.out.print("* ");
            triangle1(r, c + 1);           

        } else {
            System.out.println();       // for next row
            triangle1(r - 1, 0);
        }
    }


/*  triangle2
*
* *
* * *
* * * *
* * * * *
 */
    static void triangle2(int r, int c) {
        if (r == 5 ) {
            return;
        }
        if (c <= r) {
            System.out.print("* ");
            triangle2(r, c + 1);

        } else {
            System.out.println();      
            triangle2(r + 1 , 0);
        }
    }

     
}
