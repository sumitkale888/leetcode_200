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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(temp!=null&&temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
        return head;
        
    }
}

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

// remove all duplicates from a sorted linked list


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
           ListNode dummy=new ListNode(-1);
           dummy.next=head;
           ListNode current=dummy;
           while(current.next!=null&&current.next.next!=null){
            if(current.next.val==current.next.next.val){
                int dv=current.next.val;
                while(current.next!=null&&current.next.val==dv){

                
                current.next=current.next.next;}
            } else{
                current=current.next;
            }
           
              
           }
           return dummy.next;
        

      
    }
}