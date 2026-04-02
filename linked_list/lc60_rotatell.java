/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            temp = temp.next;
            len += 1;

        }
        if (k % len == 0) {
            return head;
        }
        k = k % len;
        temp.next = head;

        ListNode newLast = head;
        for (int i = 1; i < len - k; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;
        return head;
    }

}