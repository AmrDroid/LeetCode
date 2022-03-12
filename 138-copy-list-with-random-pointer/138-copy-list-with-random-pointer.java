/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
   
    public Node copyRandomList(Node head) {

      Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = p.next.next;
        }
        
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        
        Node dummy = new Node(0);
        Node q = dummy;
        p = head;
        while (p != null) {
            q.next = p.next;
            p.next = p.next.next;
            p = p.next;
            q = q.next;
        }
        
        return dummy.next;
    }
}