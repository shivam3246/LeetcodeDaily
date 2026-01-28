package Questions;

import java.util.*;
//https://leetcode.com/problems/reverse-linked-list/description/



public class ReverseLinkedList {
    public static class  ListNode{
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

    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }   
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while(present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if(next!=null){
                next = next.next;
            }

        }
        return prev;
    }
    public static void printList(ListNode head){
       while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, 
            new ListNode(2, 
                new ListNode(3, 
                    new ListNode(4,
                         new ListNode(5, null)))));  //Output => [5,4,3,2,1]

                         printList(head);
                         System.out.println( );
                         ListNode newHead = reverseList(head);
                         printList(newHead);
    }
}
