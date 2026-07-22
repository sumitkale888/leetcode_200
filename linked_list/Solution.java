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

Complexity
Time: O(m + n)
One traversal to compute each length.
One traversal to align and compare pointers.
Space: O(1) (constant extra space)
Core intuition in one sentence

By skipping the extra nodes in the longer list, both 
pointers become the same distance from the end, so moving
 them together guarantees they either meet at the first intersection 
 node or both reach null simultaneously.