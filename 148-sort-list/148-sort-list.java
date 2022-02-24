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
    public ListNode sortList(ListNode head) {
        if(head==null)return null;
          List<Integer> l=new ArrayList();
        ListNode res=null;
        while(head!=null)
        {
            l.add(head.val);
            head=head.next;            
        }
        
        Collections.sort(l);
        res=new ListNode(l.get(0));
        ListNode h=res;
        for(int i=1;i<l.size();i++)
        {
            res.next=new ListNode(l.get(i));
            res=res.next;
        }
        return h;
        
    }
}