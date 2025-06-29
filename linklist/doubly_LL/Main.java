package linklist.doubly_LL;

import linklist.singly_LL.CustomSLL;

public class Main {
    public static void main(String[] args) {
        CustomDLL list = new CustomDLL();
        list.insertfirst(35);
        list.insertfirst(46);
        list.insertfirst(66);
        list.insertfirst(90);
        list.display();              // 90 -> 66 -> 46 -> 35 -> End
        list.displayRev();           // 35 -> 46 -> 66 -> 90 -> Start
        list.insertafter(66 , 1);
        list.display();
    }
}
