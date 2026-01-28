package Questions;
//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedLists {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode(0);
        ListNode dummy = curr;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next = list1;
                list1=list1.next;
            }
            else{
                curr.next = list2;
                list2=list2.next;
            }
            curr = curr.next;
        }
        curr.next=list1!=null?list1:list2;
        return dummy.next;
    }
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" -> ");
            head=head.next;
        }
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));
        ListNode updatedList=mergeTwoLists(list1, list2);
        printList(updatedList);

        
    }
    
}
