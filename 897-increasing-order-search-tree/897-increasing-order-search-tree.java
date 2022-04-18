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
    TreeNode tree=new TreeNode(0);
    TreeNode result=tree;
    public TreeNode increasingBST(TreeNode root) {
        
        result=tree;
        inorder(root);
        
        
        return result.right;
    }
    
    void inorder(TreeNode root)
    {
        if(root==null)
            return ;
        
        inorder(root.left);

        tree.right=root;
        root.left=null;
        tree=tree.right;
        
        inorder(root.right);
        
    }
    

}