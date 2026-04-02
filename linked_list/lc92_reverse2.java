public class lc92_reverse2 {
    
}
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // move to node before left
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        // reverse in-place
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}

// 🔹 Intuition for the in-place reversal code

// Think of the linked list like this:

// 1 → 2 → 3 → 4 → 5

// You want to reverse only a part (from left to right), not the whole list.

// 🔹 Core Idea (Very Important)

// 👉 Instead of reversing normally, we pull nodes one by one to the front of the sublist

// 🔹 Visualization

// We focus only on this part:

// prev → 2 → 3 → 4 → next

// Where:

// prev → node before left
// curr → start of sublist (2)
// 🔹 What we do repeatedly

// Take the next node (temp) and move it right after prev