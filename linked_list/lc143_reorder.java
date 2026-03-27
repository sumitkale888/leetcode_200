/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;`
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode m=findmiddle(head);
        ListNode right=rev(m.next);
        m.next=null;
        ListNode left=head;
       

        while(right!=null){
            ListNode lnext=left.next;
            ListNode rnext=right.next;

            left.next=right;
            right.next=lnext;

            left=lnext;
            right=rnext;
        }
        

       
        
    }
    public ListNode rev(ListNode head){
        ListNode curr=head;
        ListNode temp=null;
        while(curr!=null){
            ListNode front=curr.next;
            curr.next=temp;
            temp=curr;
            curr=front;
            
            
        }
        return temp;
    }
    public ListNode findmiddle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
             slow=slow.next;
            fast=fast.next.next;
           
    }
        return slow;
    }
}