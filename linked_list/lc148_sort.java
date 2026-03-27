class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;

        ListNode middle=findmiddle(head);
        ListNode right=middle.next;
        middle.next=null;
        ListNode left=head;

       ListNode lefthead=  sortList(left);
       ListNode righthead=  sortList(right);

       return combinetwosortedlist(lefthead,righthead);

            }


    public ListNode findmiddle(ListNode head){
        ListNode slow=head;
         ListNode fast=head.next;//for correct middle,tortois return midle= 3 if 1 2 3 4

         while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
         }
         return slow;
    }

    public ListNode combinetwosortedlist(ListNode t1,ListNode t2){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(t1!=null&&t2!=null){
            if(t1.val<t2.val){
                temp.next=t1;
                temp=t1;
                t1=t1.next;
            }else{
                 temp.next=t2;
                temp=t2;
                t2=t2.next;

            }
        }
        if(t1!=null){
            temp.next=t1;

        }else{
            temp.next=t2;
        }
        return dummy.next;
    }
}