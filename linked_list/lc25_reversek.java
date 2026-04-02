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

// ListNode newhead = reverse(head, k);
// head.next = reverseKGroup(curr, k);
// return newhead;
// 1. ListNode newhead = reverse(head, k);

// 👉 This reverses the first k nodes

// Before: 1 → 2 → 3
// After : 3 → 2 → 1
// newhead → points to 3 (new start of this group)
// head → still points to 1 (now becomes tail)
// 🔹 2. head.next = reverseKGroup(curr, k);

// 👉 Important line (connection)

// curr → points to next part (4 → 5 → 6)
// Recursively reverse remaining list

// So:

// reverseKGroup(4 → 5 → 6, 3)
// → 6 → 5 → 4

// Now connect:

// 1.next = 6

// 👉 Full list becomes:

// 3 → 2 → 1 → 6 → 5 → 4
// 🔹 3. return newhead;

// 👉 Return the new head of this reversed group

// For first call → returns 3
// That becomes final head of list
// 🔹 Key Understanding
// Variable	Meaning
// newhead	head of reversed k group
// head	becomes tail after reversal
// curr	start of next group
// 🔹 One-line intuition

// 👉 “Reverse first k nodes, then connect its tail to recursively processed rest”

// 🔹 Visual Flow
// (1 → 2 → 3) → (4 → 5 → 6)

// ↓ reverse first
// (3 → 2 → 1)

// ↓ connect recursion
// (3 → 2 → 1) → (6 → 5 → 4)