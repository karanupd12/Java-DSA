package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class MultidimArrList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(10);   //syntax of nested ArrayList :- arraylists with an arraylist

        //initialisation
        for(int i=0 ; i<3 ;i++){
            list.add(new ArrayList<>());
        }

        //add elements
        for(int i=0 ; i<3 ; i++){
            for (int j=0 ; j<3 ; j++){
                list.get(i).add(sc.nextInt());   //list.get(i) :- gives me list at index i 
            }
        }

        System.out.println(list);
    }
}
