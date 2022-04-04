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
    public ListNode reverseKGroup(ListNode head, int k) {
     
       if (head == null)
            return null;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;
        
        ListNode l=head;
         while (l != null && count != k) {
            l = l.next;
            count++;
        }

        if(count==k)
        {
            count=0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        
            count++;
        }
                    /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverseKGroup(next, k);
            
        }
        else
        {
            System.out.println(head.val);
            prev=head;
        }


      

        // prev is now head of input list
        return prev;
            
        
    }
}