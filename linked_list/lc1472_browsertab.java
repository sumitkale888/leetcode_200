public class lc1472_browsertab {
    
}
class Node{
    String val;
    Node next;
    Node back;

  public  Node(String val,Node next,Node back){
        this.val=val;
        this.next=next;
        this.back=back;
    }
     public  Node(String val){
        this.val=val;
        
    }
}

class BrowserHistory {
    Node curr;



    public BrowserHistory(String homepage) {
        curr=new Node(homepage);
        
    }
    
    public void visit(String url) {
        Node newnode=new Node(url);
        curr.next=newnode;
        newnode.back=curr;
        newnode.next=null;
        curr=newnode;
        
    }
    
    public String back(int steps) {
        while(steps!=0){
            if(curr.back!=null){
            curr=curr.back;
            steps--;}
            else{
                break;
            }
        }
        return curr.val;
        
    }
    
    public String forward(int steps) {
        while(steps!=0){
            if(curr.next!=null){
                curr=curr.next;
                steps--;
            }else{
                break;
            }
        }
        return curr.val;
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */