package linklist.singly_LL;


public class Main {
    public static void main(String[] args) {
        CustomSLL list = new CustomSLL();
        list.insertfirst(35);      // 35
        list.insertfirst(46);      // 46 -> 35
        list.insertlast(14);       // 46 -> 35 -> 14
        list.insertlast(15);       // 46 -> 35 -> 14 -> 15
        list.insert(2,10);   // 46 -> 35 -> 10 -> 14 -> 15

        list.display();               // 46 -> 35 -> 10 -> 14 -> 15 -> END

        list.deletefirst();           //46 >>> returns the deleted value
        list.display();               // 35 -> 10 -> 14 -> 15 -> END

        list.deletelast();            //15 >>> returns the deleted value
        list.display();               //35 -> 10 -> 14 -> END

        list.delete(1);        //10 >>> returns the deleted value
        list.display();              //35 -> 14 -> END
    }
}
