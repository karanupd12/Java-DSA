package search.linear_search;

public class Questions {
    public static void main(String[] args) {
        int[] arr={18,12,45,65,77,89,32};
        System.out.println("minimum no is = "+minIn(arr));               //Ans1 - 12
        System.out.println("maximum no is = "+maxIn(arr));               //Ans2 - 89

        int[] nums={12, 345 , 2 , 6 , 7891 , 34, 234, 865431 , 9987 , 136};
        System.out.println(findNumbers(nums));                           //Ans - 5
    }

//Ques1 - Search for min no in array

//answer1
    public static int minIn(int[] arr){
        if (arr.length==0){
            return -1;
        }
        int min=arr[0];
        for (int index=0 ; index<arr.length ; index++){
            if (arr[index] < min){
                min=arr[index];                                               
            }
        }   
        return min; 
    }

//Ques2 - Search for max no in array

//answer2
    public static int maxIn(int[] arr){
        if (arr.length==0){
            return -1;
        }
        int max=arr[0];
        for (int index=0 ; index<arr.length ; index++){
            if (arr[index] > max){
                max=arr[index];                                
            }
        }   
        return max;
    }

//Ques3 - Given an array of integers, return how many of them contatins even no of digits.
//nums = [12, 345 , 2 , 6 , 7891 , 34, 234, 865431 , 9987 , 136]      //ans = 5 (i.e; 12 ,7891, 865431, 9987 have even no of digits)

//answer3
    public static int findNumbers(int[] nums){
        int count = 0;
        for (int num : nums){                   //select each number(num) in nums array 
            if (even(num)){                     //checking      
                count ++;                       // will run if line52 is true
            }
        }
    return count;                               //return 2
    }

    //function to check whether a number contains even no of digits or not
    static boolean even(int num){
        int numberofdigits = digits(num);       
        return numberofdigits % 2==0;           //will return true if no of digits in num will be even
    }

    //count no. of digits in a number
    static int digits (int num){                
        int count = 0;
        while (num>0){                          
            count++;
            num/=10; 
        }
        return count;                           //this will return total number of digits present in a num in nums array
    }
}
 