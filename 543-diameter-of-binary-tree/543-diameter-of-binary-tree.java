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
    public int diameterOfBinaryTree(TreeNode root) {
        
       return helper(root,new Height())-1; 
    }
    int helper (TreeNode root, Height h)
    {
        
          Height lh = new Height(), rh = new Height();

        
        if(root==null)
        {
            h.h=0;
            return 0;
        }
        
        int lDiameter = helper(root.left,lh);
        int rDiameter = helper(root.right,rh);
        
        
        h.h= Math.max(lh.h,rh.h)+1;
        
        return Math.max(lh.h+rh.h+1,Math.max(lDiameter,rDiameter));
        
    }
    
    
    class Height{
        int h;
    }
}