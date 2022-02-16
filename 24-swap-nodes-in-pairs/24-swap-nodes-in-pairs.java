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
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        ListNode res=head;
        while(head.next!=null)
        {
            int x=head.val;
            head.val=head.next.val;
            head.next.val=x;
            head=head.next.next!=null? head.next.next:head.next;
        }
        return res;
    }
}