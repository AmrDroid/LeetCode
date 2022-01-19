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
    public ListNode detectCycle(ListNode head) {
        
        if(head==null||head.next==null)return null;
        
        
        int prev=-1,curr=0;
        ListNode first=head;
        ListNode last=head;
        ListNode prevNode=head;
        while(prev<curr&&last!=null)
        {
            prev=curr;
            
            curr=distance(first,last);
            prevNode=last;
            last=last.next;
            
        }
        System.out.println(prevNode.val);
        
        if(last!=null)
            return prevNode;
        return null;
    }
    
    int distance(ListNode first,ListNode last)
    {
        
        int counter =0;
        
        ListNode temp=first;
        
        while(temp!=last)
        {
            
            counter ++;
            
            temp=temp.next;
        }
        
        return counter+1;
        
        
    }
}