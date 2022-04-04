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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode h= head;
        List<Integer> l = new ArrayList();
        while(h!=null)
        {
            l.add(h.val);
            h=h.next;
        }
        
        int temp = l.get(k-1);
        int n =l.size();
        l.set(k-1,l.get(n-k));
        l.set(n-k,temp);
        
        
        h= head;
        for(Integer i : l)
        {
            head.val = i;
            head=head.next;
        }
        
        return h;
    }
}