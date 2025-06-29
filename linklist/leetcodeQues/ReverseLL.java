package linklist.leetcodeQues;

import java.util.LinkedList;
import java.util.List;

public class ReverseLL {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head){
        if (head == null){
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode nextnode = current.next;
            current.next = prev;
            prev = current;
            current = nextnode;
        }
        return prev;
    }
}
