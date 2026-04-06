class Solution {
    public int pairSum(ListNode head) {
        ListNode m=findmiddle(head);
        ListNode newhead=m.next;
        m.next=null;
        ListNode first=head;
        ListNode second=reverse(newhead);
        int max=Integer.MIN_VALUE;
        int sum=0;
        while(first.next!=null){
            sum=first.value+second.val;
            if(sum>max){
                max=sum;
            }
            first=first.next;
            second=second.next;

        }
        return max;       
    }
    Public ListNode findmiddle(ListNode head){
        ListNode s=head;
        ListNode f=head;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr.next!=null){
            ListNode front=curr.next;
            curr.next=prev;
           
            prev=curr;
            curr=front;
            
        }
        return prev;


    }
}