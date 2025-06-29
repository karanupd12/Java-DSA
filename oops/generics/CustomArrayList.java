//arrayList and the methods used in ti like add, remove, set, clear are already inbuilt and given to us by java
//now we will learn how to create our own custom arraylist methods

package oops.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList{

    //try tom keep confidential data and info private
    private int[] data;
    private static int Default_size = 5;
    private int size = 0;       //also working as index value

    public CustomArrayList() {               //constructor for custom arraylist
        this.data = new int[Default_size];
    }

    public void adding(int num){                //we are creating an "add" function
        if (isfull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];

        //copy the current items in the new array
        for(int i = 0; i<data.length; i++){
            temp[i] = data[i];
        }

    }

    private boolean isfull(){
        return size == data.length;
    }

    public int removing(){
        int removed = data[--size];
        return removed;
    }

    public int getting(int index){
        return data[index];
    }

    public int findsize(){
        return size;
    }

    public void setting(int index , int value){
        data[index] = value;
    }

    public String tostring(){
        return Arrays.toString(data);
    }


    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.adding(34);    //[34, 0, 0, 0, 0]
        System.out.println(list.tostring());
        list.adding(45);    //[34, 45, 0, 0, 0]
        list.adding(56);    //[34, 45, 56, 0, 0]
        list.findsize();          // 3
        list.getting(1);   //45
        list.setting(0,30);   //[30, 45, 56, 0, 0]
        list.removing();          //[30, 45, 56, 0, 0]
        System.out.println(list.tostring());   //[30, 45, 56, 0, 0]
    }
}
