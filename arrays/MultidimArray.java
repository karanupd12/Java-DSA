package arrays;

import java.util.*;

/* multidimensional arrays i.e; 2D arrays stores the data in the form of matrix (rows and cols format)
 *      
 *                  1  8  3  
 *                  5  2  9  
 *                  4  2  1  
 */

public class MultidimArray {
    public static void main(String[] args) {

        int[][] arr1={
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(arr1[1][2]);          //6

        //or

        //INPUT
        Scanner sc=new Scanner(System.in);
        int[][] arr = new int[3][3];

        for(int row=0 ; row<arr.length ; row++){
            for (int col=0 ; col<arr.length ; col++){
                System.out.print("enter an element=");
                arr[row][col]=sc.nextInt();
            }
        }

        //OUTPUT
        for(int row=0 ; row<arr.length ; row++){
            for (int col=0 ; col<arr.length ; col++){
                System.out.print((arr[row][col]) + " ");
            }
            System.out.println();
        }

        System.out.println();
//or
        //better method
        for(int row=0 ; row<arr.length ; row++){
            System.out.println(Arrays.toString(arr[row]));
        }

        System.out.println();
//or
        //enchanced for loop : much better
        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
    }
}
