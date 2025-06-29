package linklist.singly_LL;

import java.util.LinkedList;

public class Linkedlist {
    public static void main(String[] args) {
        //syntax
        LinkedList<Integer> list = new LinkedList<>();

        //now you can add as many elements as you want
        list.add(45);
        list.add(67);
        list.add(68);
        list.add(39);
        list.add(33);
        list.add(59);
        list.add(23);
        list.add(88);
        list.add(28);

        //operations on linkedlist
        System.out.println(list);                   //[45, 67, 68, 39, 33, 59, 23, 88, 28]
        System.out.println(list.contains(33));    //true

        list.set(0,54);
        System.out.println(list);                   //[54, 67, 68, 39, 33, 59, 23, 88, 28]

        list.remove(1);
        System.out.println(list);                   //[54, 68, 39, 33, 59, 23, 88, 28]

        list.add(1,44);               //if we don't set index, it will bydefault add it at the end
        System.out.println(list);                   //[54, 44, 68, 39, 33, 59, 23, 88, 28]
    }
}
