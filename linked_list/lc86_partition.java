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

// Given the head of a linked list and a value x, partition it such that all nodes less than
//  x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1=new ListNode(-1);
           ListNode dummy2=new ListNode(-1);
           ListNode curr1=dummy1;
        
          ListNode curr2=dummy2;

          ListNode temp=head;
          while(temp!=null){
            if(temp.val<x){
                curr1.next=temp;
                curr1=temp;
                temp=temp.next;
            }
            else if(temp.val>=x){
              
                curr2.next=temp;
                curr2=temp;
                temp=temp.next;
                
            }
            
          }
          curr2.next=null;
          curr1.next=dummy2.next;
          
        return dummy1.next;
    }
}