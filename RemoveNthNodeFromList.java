//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromList {
 public static class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 //2pass
 public static ListNode removeNthFromEnd(ListNode head, int n) {
    int size = 0;
    ListNode temp = head;
    while(temp!=null){
        size++;
        temp = temp.next;
    }    
    if(n==size){
        return head.next;
    }
    temp = head;
    for(int i = 1;i<size-n;i++){
        temp = temp.next;
    }
    temp.next = temp.next.next;
    return head;
}
//1pass solution
public static ListNode removeOnePass(ListNode head,int n){
      ListNode dummy = new ListNode(0,head);
      ListNode slow = dummy;
      ListNode fast = dummy;
      for(int i = 0;i<=n;i++){
        fast=fast.next;
      }
      while(fast!=null){
        
        fast=fast.next;
        slow = slow.next;
      }
      slow.next = slow.next.next;
      return dummy.next;
}
static void printList(ListNode head){
    while(head!=null){
        System.out.print(head.val+" ");
        head = head.next;
    }
}
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        int n = 2;
        //ListNode newHead = removeNthFromEnd(head, n);
        ListNode newHead = removeOnePass(head, n);
        printList(newHead);
        
    }
}
