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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     
        Map<Integer,Integer> m= new HashMap();
        
        
        for(int i=0;i<inorder.length;i++)
            m.put(inorder[i],i);
      
        
        return getBT(m,0,inorder.length-1,inorder,0,preorder.length,preorder);
    }
    
    TreeNode getBT(Map<Integer,Integer> m , int inStart,int inEnd,int inorder[],int preStart,int preEnd,int preorder[])
    {
        
        if(inEnd<inStart|| preEnd<preStart) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inRoot= m.get(root.val);
        
        
        int nodesLeft = inRoot-inStart;
        
        
        root.left= getBT(m,inStart,inRoot-1,inorder,preStart+1,preStart+nodesLeft,preorder);
        root.right=getBT(m,inRoot+1,inEnd,inorder,preStart+nodesLeft+1,preEnd,preorder);
        
        return root;
    }
}



