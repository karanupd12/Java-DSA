package linklist.circular_LL;

import linklist.singly_LL.CustomSLL;

public class Main {
    public static void main(String[] args) {
        CustomCLL list = new CustomCLL();
        list.insert(35);
        list.insert(46);
        list.insert(14);
        list.insert(15);


        list.display();  //35 -> 46 -> 14 -> 15 -> this will point again to head
        System.out.println();

        list.delete(14);
        list.display();
    }
}
