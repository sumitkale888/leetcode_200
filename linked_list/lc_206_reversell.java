package linked_list;
class Solution {
    public lc_206_reversell reverseList(lc_206_reversell head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
        
    }
}


 public class lc_206_reversell {
      int val;
     ListNode next;
   ListNode() {}
    ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 