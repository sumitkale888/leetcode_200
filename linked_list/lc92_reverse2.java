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

// 1 → 2 → 3 → 4 → 5
//     ↑
//   left=2, right=4

// After setup:

// prev → 1
// curr → 2
// sublist = 2 → 3 → 4
// 🔹 Iteration 1
// temp = curr.next → 3
// Step:
// Remove 3 from its place
// Insert it after prev
// 1 → 3 → 2 → 4 → 5
//         ↑
//       curr still here

// 👉 Important:

// curr stays at 2
// We are building reversed part in front of curr
// 🔹 Iteration 2
// temp = curr.next → 4
// Step:
// Remove 4
// Insert after prev
// 1 → 4 → 3 → 2 → 5
// 🔹 What just happened?

// Original sublist:

// 2 → 3 → 4

// After operations:

// 4 → 3 → 2
// 🔹 Key Insight

// Each loop:

// curr → A → B → C

// We:

// Take B
// Move it before A

// Result:

// curr → A → C
// prev → B → A
// 🔹 Why it works
// curr always stays at end of reversed part
// prev.next always points to start of reversed part
// We grow reversed list from front
// 🔹 Mental model

// Think like:
// 👉 “Take next node and push it to front”

// Not:
// 👉 “Reverse pointers one by one”

// 🔹 Complexity
// Time: O(n)
// Space: O(1)