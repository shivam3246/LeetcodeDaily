
//https://leetcode.com/problems/middle-of-the-linked-list/description/
import java.util.*;
public class MiddleOfTheLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(){

        }
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }

    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;

        }
        
        return slow;
        
    }

    public void printList(ListNode head){
        System.out.print("Middle of the list ");
       while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        MiddleOfTheLinkedList m = new MiddleOfTheLinkedList();
        ListNode head = m.new ListNode(1,m.new ListNode(2,m.new ListNode(3,m.new ListNode(4,m.new ListNode(5,null)))));
        ListNode newRes = m.middleNode(head);
        m.printList(newRes);
    }
    
}
