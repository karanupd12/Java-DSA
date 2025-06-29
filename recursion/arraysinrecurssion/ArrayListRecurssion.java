//searching a target present multiple times in an array : by printing a list of its all indexes using arraylist via recursion
package recursion.arraysinrecurssion;

import java.util.ArrayList;

public class ArrayListRecurssion {
    public static void main(String[] args) {
        int[] arr = { 12, 34, 45, 56, 34, 45, 67, 34, 89, 90 };
        int target = 34;

        //M1
        ArrayList<Integer> list1 = new ArrayList<>(); // creating an arraylist nameed as 'list1' of type integer
        ArrayList<Integer> ans = findallindex1(arr, target, 0, list1);
        System.out.println(ans); // [1 , 4 , 7]
        
        //M2
        ArrayList<Integer> list2 = new ArrayList<>(); // creating an arraylist nameed as 'list2' of type integer
        list2 = findallindex2(arr, target, 0);
        System.out.println(list2); // [1 , 4 , 7]

    }

//Method 1 : by passing an arraylist in argument
    static ArrayList<Integer> findallindex1(int[] arr, int target, int index, ArrayList<Integer> list1) { 
        // base condition
        if (index == arr.length) {
            return list1; // returning list of indexes occupied by 34
        }
        if (arr[index] == target) {
            list1.add(index);
        }
        return findallindex1(arr, target, index + 1, list1);
    }


//Method 2 : without passing arraylist in argument
//to achieve this , we will create an arraylist at every function call and add all the ans of different function call to get final list2

    static ArrayList<Integer> findallindex2(int[] arr, int target, int index) { 
        ArrayList<Integer> list2 = new ArrayList<>();
        // base condition
        if (index == arr.length) {
            return list2; // returning list of indexes occupied by 34
        }
        //this will contain answer for that function call only
        if (arr[index] == target) {
            list2.add(index);
        }
        ArrayList<Integer> answerFromBelowCalls = findallindex2(arr , target , index+1 );//creating new object(ans) at every function call until base condition is reached (index = 0 to arr.length-1)
        list2.addAll(answerFromBelowCalls); //adding from bottom to up  (every ans at every function call)
        return list2;
    }

}
