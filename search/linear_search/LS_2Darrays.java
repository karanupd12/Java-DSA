package search.linear_search;

import java.util.Arrays;

public class LS_2Darrays {
    public static void main(String[] args) {
        int arr[][]={
            {14, 25, 38},
            {42, 57, 61, 75},
            {86, 93, 34, 71},
            {21, 45}
        };
        int target=45;
        System.out.println(Arrays.toString(searchin(arr,target)));
    }
    public static int[] searchin(int[][] arr , int target){
        for(int row=0 ; row<arr.length ; row++){
            for(int col=0 ; col<arr[row].length ; col++){
                if (arr[row][col]==target){
                    return new int [] {row+1 , col+1};
                }
            }
        }
        return new int [] {-1 , -1};
    }
}