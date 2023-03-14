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
    public boolean isSymmetric(TreeNode root) {
             if(root==null)return true;
        
        return isMirror(root,root);
        
        
    }
    boolean isMirror(TreeNode sNode1, TreeNode sNode2) {
        if (sNode1 == null && sNode2 == null)
            return true;
        if (sNode1 != null && sNode2 != null && sNode1.val == sNode2.val)
            return (isMirror(sNode1.left, sNode2.right) && isMirror(sNode1.right, sNode2.left));
        return false;
    }
}