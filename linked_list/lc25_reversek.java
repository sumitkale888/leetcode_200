/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        int c=0;
        while(curr!=null&&c<k){
            curr=curr.next;
            c++;
        }  
        if(c==k){
            ListNode newhead=reverse(head,k);
            head.next=reverseKGroup(curr,k);
            return newhead;

        }     
        return head;
    }
    public ListNode reverse(ListNode head,int k){
        ListNode curr=head;
        ListNode prev=null;
        while(k!=0){
            ListNode front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
            k--;
        }
        return prev;
    }
}