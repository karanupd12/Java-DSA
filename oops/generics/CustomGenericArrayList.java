//arrayList and the methods used in ti like add, remove, set, clear are already inbuilt and given to us by java
//now we will learn how to create our own custom arraylist methods

package oops.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomGenericArrayList<T>{            //T = type of arraylist

    //try tom keep confidential data and info private
    private Object[] data;
    private static int Default_size = 15;
    private int size = 0;       //also working as index value

    public CustomGenericArrayList() {               //constructor for custom arraylist
        this.data = new Object[Default_size];
    }

    public void adding(T num){                //we are creating an "add" function
        if (isfull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        //copy the current items in the new array
        for(int i = 0; i<data.length; i++){
            temp[i] = data[i];
        }

    }

    private boolean isfull(){
        return size == data.length;
    }

    public T removing(){
        T removed = (T)data[--size];
        return removed;
    }

    public T getting(int index){
        return (T)data[index];
    }

    public int findsize(){
        return size;
    }

    public void setting(int index , T value){
        data[index] = value;
    }

    public String tostring(){
        return Arrays.toString(data);
    }


    public static void main(String[] args) {
        CustomGenericArrayList<Integer> list = new CustomGenericArrayList<>();
        for(int i = 0 ; i<10 ; i++){
            list.adding(2*i);
        }

        System.out.println(list.tostring());
        System.out.println(list.findsize());
    }
}

