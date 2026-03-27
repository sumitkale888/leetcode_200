/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class lc142_cycle2 {
    public ListNode detectCycle(ListNode head) {
       ListNode fast=head;
       ListNode slow=head;
       while(fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(fast==slow){
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return fast;
        }
       }
        return null;
    }
}

// 3️⃣ Length of Cycle (very common follow-up)

// After slow and fast meet:

// Keep one pointer fixed

// Move other until it comes back

// Count steps

// Example code idea:

// int count = 1;
// ListNode temp = slow.next;

// while(temp != slow){
//     count++;
//     temp = temp.next;
// }



// Find Node Before Cycle Start (Solution)

// Idea:

// First detect cycle.

// Find start of cycle (same as Linked List Cycle II).

// Traverse cycle until node.next == start → that node is before start.

// public ListNode nodeBeforeCycleStart(ListNode head) {
//     ListNode slow = head;
//     ListNode fast = head;

//     // Step 1: detect cycle
//     while (fast != null && fast.next != null) {
//         slow = slow.next;
//         fast = fast.next.next;

//         if (slow == fast) {

//             // Step 2: find cycle start
//             ListNode ptr1 = head;
//             ListNode ptr2 = slow;

//             while (ptr1 != ptr2) {
//                 ptr1 = ptr1.next;
//                 ptr2 = ptr2.next;
//             }

//             ListNode start = ptr1;

//             // Step 3: find node before start
//             ListNode temp = start;
//             while (temp.next != start) {
//                 temp = temp.next;
//             }

//             return temp;  // node before cycle start
//         }
//     }

//     return null; // no cycle
// }
