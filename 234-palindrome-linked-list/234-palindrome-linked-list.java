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
    public boolean isPalindrome(ListNode head) {
     
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
        
    fast = reverse(slow);
    slow = head;

    while (fast != null) {

       if (slow.val != fast.val) return false;

      slow = slow.next;
      fast = fast.next;
    }

    return true;
  }

  private ListNode reverse(ListNode node) {
      
    ListNode prevNode = null, nextNode = null;
  
      while (node != null) {
      
          nextNode = node.next;
          node.next = prevNode;

          prevNode = node;
          node = nextNode;

      }
      
    return prevNode;
  }
        
        
}