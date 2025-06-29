//Arrays :- collection of elements of same data types

//syntax:-                    (declaration + initialization)       >>>        datatype[] variable_nsme = new datatype[size];
//                                                                  or
//          (dirct : declaration + initialization + assigning)     >>>        datatype[] variable_name = {d1,d2,d3,d4.....dn};

package arrays;
import java.util.*;

public class ArrayConcept {
    public static void main(String[] args) {
        
        int [] arr;                              //declaration of an array : ros is getting defined in the stack : happens at compile time
        arr = new int[5];                        //initialization of array : object is being created in the memory (heap) : happens at runtime (DMA)
        //or                                     // (DMA : dynamic memory allocation : memory allocated at runtime)
        int[] arr1 = new int [5]; 
        // or
        int[] arr2 = {23,12,55,4,78,63,42}; 
        String[] arr3=new String [5];            // string array
        
        System.out.println( arr2[0]);            //23
        System.out.println( arr2[3]);            //4
        System.out.println( arr2[6]);            //42
        System.out.println(arr2.length);         //7      >>>     "array_name.length" tells us the size/length of array  
        System.out.println(arr1[0]);             //0      >>>     for primitive(simpler) data types (int, char, boolean, float)
        System.out.println(arr3[0]);             //null   >>>     for non primitive (complex) data types : this is because when we create array, the array is defined in stack but the objects stored in reference variable in heap memory, right now we have not assigned anything on 0th index, so the reference variables are empty in heap memory therefore it is giving us null.

        // ARRAY INPUT
        
        //array of primitives
        int[] arr4 = new int[5];
        arr4[0]=23;
        arr4[1]=24;
        arr4[2]=25;
        arr4[3]=26;
        arr4[4]=27;
        //[23,24,25,26,27]
        System.out.println(arr4[3]);     //26
        //System.out.println(arr4[5]);     //error : index out of bound
 
        //using for loop
        int[] arr5=new int[5];
        Scanner sc=new Scanner(System.in);
        for ( int i=0 ; i<arr5.length ; i++ ){
            System.out.print("enter element=");
            arr5[i]=sc.nextInt();           
        }

        //ARRAY OUTPUT
        for ( int i=0 ; i<arr5.length ; i++ ){
            System.out.print(arr5[i]+" ");
        }
       System.out.println();

        //or

        System.out.println(Arrays.toString(arr5));    //to print whole array in one go, will convert it to string type

        //or

        for (int num : arr5 ){                     //for every element in the array, print the element
            System.out.print(num + " ");           //here, num represents element in the array
        }
        System.out.println();
        

        //array of non primitives
        Scanner in=new Scanner(System.in);
        String[] str=new String[5];
        for(int i=0 ; i<5 ; i++){
            System.out.print("enter element=");
            str[i]=in.next();
        }
        System.out.println(Arrays.toString(str));

        //modify 
        str[3]="anuj";

        System.out.println(Arrays.toString(str));
    }
}
