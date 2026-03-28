/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=length(headA);
        int l2=length(headB);
        if(l1>l2){
            for(int i=0;i<(l1-l2);i++){
                headA=headA.next;
            }
        }else{
            for(int i=0;i<(l2-l1);i++){
                headB=headB.next;
            }

        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

        
    }
    public int length(ListNode a){
        int c=0;
        while(a!=null){
            c++;
            a=a.next;
        }
        return c;
    }
}