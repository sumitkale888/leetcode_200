public class lc707_designll {
    
}
class MyLinkedList {
    Node head;
    int s;
    
    class Node{
        int val;
        Node next;

        Node(int val,Node next){
            this.val=val;
            this.next=next;

        }
        Node(int val){
            this.val=val;
            this.next=null;
          

        }

    }
   

    public MyLinkedList() {
         head=null;
         s=0;
        
    }
    
    public int get(int index) {
        if(index<0||index>=s){
            return -1;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
            
        }
       return temp.val;
        
    }
    
    public void addAtHead(int val) {
         Node n=new Node(val);
        if(head==null){
            head=n;
            s++;
            return;
        }

       
        n.next=head;
        head=n;
        s++;
        
    }
    
    public void addAtTail(int val) {
        Node t=head;
         Node n=new Node(val);
        if(head==null){
           
            head=n;
            s++;
            return;
        }
        while(t.next!=null){
            t=t.next;
        }
       
        t.next=n;
       s++;
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0||index>s){
            return ;
        }
        if(index==0){
            addAtHead(val);
            return;

        }
        if(index==s){
            addAtTail(val);
            return;

        }
        Node n=new Node(val);
        Node t=head;
        for(int i=1;i<index;i++){
            t=t.next;
        }
        n.next=t.next;
        t.next=n;
        s++;
        
    }
    
    public void deleteAtIndex(int index) {
         if(index<0||index>=s){
            return ;
        }
        if(index==0){
            head=head.next;
            s--;
            return;
        }
        Node t=head;
        for(int i=1;i<index;i++){
            t=t.next;
        }
        t.next=t.next.next;
        s--;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */