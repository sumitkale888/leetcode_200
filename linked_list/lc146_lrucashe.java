public class lc146_lrucashe {
    
}
class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    HashMap<Integer,Node>map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        

        map=new HashMap<>();

        head=new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;
        
    }

    public void delete(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insert(Node node){
        node.next=head.next;
        node.prev=head;

        head.next.prev=node;
        head.next=node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);

        delete(node);
        insert(node);

        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;

            delete(node);
            insert(node);

            return;
        }
        if(map.size()==capacity){
            Node lru=tail.prev;
            delete(lru);

            map.remove(lru.key);
        }

        Node node=new Node(key,value);

        insert(node);
        map.put(key,node);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// The core intuition of an LRU Cache is to answer one question efficiently:

// When the cache is full, which item should be removed?

// The LRU policy says:

// Remove the item that has not been used for the longest time.

// To do this efficiently, we need two capabilities:

// Find a key quickly → use a HashMap.
// Know which key is least/most recently used and update that order quickly → use a Doubly Linked List.
// Why HashMap?

// Suppose the cache contains:

// 1 → 10
// 2 → 20
// 3 → 30

// If someone calls:

// get(2)

// We must immediately find the node containing key 2.

// Without a HashMap:

// 1 -> 2 -> 3

// You would have to traverse the list.

// Time = O(n)

// With a HashMap:

// map.get(2)

// Time = O(1)

// Purpose of HashMap:

// Key → Node
// Instant lookup
// Why Doubly Linked List?

// We also need to remember which node was used most recently.

// Suppose

// Head(MRU)

// 3 ⇄ 2 ⇄ 1

// Tail(LRU)

// Head = Most Recently Used

// Tail = Least Recently Used

// If

// get(2)

// then 2 becomes most recently used.

// New order

// 2 ⇄ 3 ⇄ 1

// A linked list naturally maintains this order.

// Why not only HashMap?

// HashMap stores

// 1 → Node1
// 2 → Node2
// 3 → Node3

// It does not store usage order.

// If the cache becomes full, how do you know which key is least recently used?

// You don't.

// You'd have to inspect every entry.

// Time = O(n)

// Why not only Doubly Linked List?

// Suppose

// 3 ⇄ 2 ⇄ 1

// Now

// get(2)

// How do you find node 2?

// You must traverse

// 3
// ↓
// 2

// Time = O(n)

// Why Doubly Linked List instead of Singly Linked List?

// Whenever a node is accessed, we move it to the front.

// To move a node, we first remove it.

// For example,

// Head

// 3 ⇄ 2 ⇄ 1

// Tail

// Move 2 to the front.

// First remove 2.

// With a doubly linked list:

// node.prev.next = node.next;
// node.next.prev = node.prev;

// The node knows both its previous and next neighbors, so removal takes O(1).

// With a singly linked list, a node only knows its next pointer.

// To remove 2, you first need to find its previous node (3) by traversing from the head.

// Time = O(n)

// That is why LRU uses a doubly linked list.

// Why Dummy Head and Tail?

// Instead of handling many edge cases:

// Empty list
// One node
// Insert at front
// Delete first node
// Delete last node

// we create two dummy nodes.

// Initially:

// head ⇄ tail

// After inserting 10:

// head ⇄ 10 ⇄ tail

// After inserting 20:

// head ⇄ 20 ⇄ 10 ⇄ tail

// Now every insertion happens after head, and every deletion of the least recently used node happens before tail.

// No special cases are needed.

// Complete Intuition

// Imagine the cache as a queue of recently used items.

// Most Recently Used                    Least Recently Used

// Head
//  ↓
// 5 ⇄ 2 ⇄ 8 ⇄ 1
//                ↑
//              Tail
// get(8) → Move 8 to the front.
// put(10) when full → Remove 1 (tail's previous node) and insert 10 at the front.
// put(2, newValue) → Update its value and move 2 to the front.
// Responsibilities of each data structure
// Data Structure	Responsibility
// HashMap	Find a node by key in O(1)
// Doubly Linked List	Maintain the usage order and support O(1) insertion, deletion, and moving nodes
// Head	Points to the Most Recently Used (MRU) end
// Tail	Points to the Least Recently Used (LRU) end
// Dummy Nodes	Simplify insertion and deletion by eliminating edge cases