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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a.val,b.val)
        );
        for(int i=0;i<lists.length;i++){
           if(lists[i]!=null) pq.add(lists[i]);
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;

        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            temp.next=node;
            temp=temp.next;

            if(node.next!=null){
                pq.add(node.next);
            }
        }
        return dummy.next;

        
    }
}
// 🔑 Core intuition

// You have k sorted linked lists.
// Goal → merge into one sorted list.

// 👉 Instead of comparing all lists manually, we always pick the smallest available node.

// 💡 Why Priority Queue (Min Heap)?

// At any moment:

// You only care about the smallest head among k lists

// 👉 Priority Queue gives:

// O(log k) access to smallest element
// 🧠 Think like this

// You have:

// List1: 1 → 4 → 5
// List2: 1 → 3 → 4
// List3: 2 → 6
// Step 1: Put first nodes in PQ
// PQ = [1, 1, 2]
// Step 2: Always pick smallest
// Remove 1 → add to answer
// Insert next from that list (4)
// PQ = [1, 2, 4]
// Step 3: Repeat
// Remove 1 → add → insert 3
// Remove 2 → add → insert 6
// Remove 3 → add → insert 4
// ...

// 👉 Always smallest comes out first

// 🔄 Why this works

// Because:

// Each list is already sorted
// PQ ensures global smallest selection
// ⚙️ Why comparator like this?
// (a, b) -> Integer.compare(a.val, b.val)

// 👉 PQ needs to know how to order nodes

// Compare nodes based on val
// Ensures min heap behavior
// ❗ Without comparator
// Java doesn’t know how to compare ListNode
// You’ll get error or wrong behavior