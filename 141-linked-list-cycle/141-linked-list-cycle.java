/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
         
        ListNode first, last;
        first = head;
        last = head;
        int current_length = 0;
        int prev_length = -1;
        while (current_length > prev_length && last != null)
        {
            prev_length = current_length;
            current_length = distance(first, last);
            last = last.next;
        }//1 3 5  4 6 3 9

        if (last == null)
        {
            return false;
        }
        else
        {
            return true;
        }
        
        
    }
    
    
      int distance(ListNode first, ListNode last)
    {

        /*counts no of nodes between first and last*/
        int counter = 0;
        ListNode curr;
        curr = first;
        while (curr != last)
        {
            counter += 1;
            curr = curr.next;
        }
        return counter + 1;
    }

}