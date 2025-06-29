//A linear search, sometimes referred to as a sequential search, simply scans each element one at a time.
// In this search, an array is sequentially traversed from the first element until the element is found or the end of the array
// is reached.
// This method can only be suitable for searching over a small array or an unsorted array.


package search.linear_search;
import java.util.Scanner;

public class LS_arrays {
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        int[] arr={34, 45, 68, 21, 79, 52, 61, 88};
        System.out.print("enter element to search =");
        int element=sc.nextInt(); 
        System.out.println(linearsearch( arr , element));       //printing the index number of the element in array

        
    }

    public static int linearsearch(int arr[] , int target){
        if (arr.length==0){
            return -1;
        }

        //using loop for search
        for (int index=0 ; index<arr.length ; index++){
            if (arr[index]==target){            //if true - we have found out our target element in this index
                return index;                   //it will return index of target element in array                            
            }
        }
        //if target is not found   
        return -1;                              //this line will execute if none of the above return statements has executed
    }
}


