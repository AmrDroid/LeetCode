/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode r) {
       
         if(r == null) return true;
        
        Queue<TreeNode> q=new LinkedList();
        
        q.add(r);
        
        while(!q.isEmpty())
        {
            
            TreeNode root= q.poll();
            if(root!=null)
            {
                q.add(root.left);
                q.add(root.right);
            }
            else
            {
                if(!q.isEmpty()&&q.peek()!=null)
                    return false;
            }
            
        }
        return true;
    }
}