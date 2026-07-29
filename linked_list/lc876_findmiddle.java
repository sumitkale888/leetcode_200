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
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }
}

// Use two pointers:

// Slow → moves 1 step at a time.
// Fast → moves 2 steps at a time.

// Since the fast pointer travels twice as quickly, 
// by the time it reaches the end of the list, the slow pointer has only
//  traveled half the distance—so it will be at the middle.