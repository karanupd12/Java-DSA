package linklist.leetcodeQues;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Pallindrome {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode head) {
        boolean pallindrome = true;
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode nextnode = current.next;
            current.next = prev;
            prev = current;
            current = nextnode;
        }
        while (prev != null && head != null){
            if (prev.val != head.val){
                pallindrome = false;
                break;
            }
            prev = prev.next;
            head = head.next;
        }
        return pallindrome;
    }
}
