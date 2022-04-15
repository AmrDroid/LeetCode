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

        


    public TreeNode bstFromPreorder(int[] nodeData) {
        

        
        TreeNode root=null;
          
        for (int i = 0; i < nodeData.length; i++)         
            root = createNode(root,nodeData[i]);
        
        return root;
    }
    
    
    public static TreeNode createNode(TreeNode node, int data) {
        
        if (node == null)
            node = new TreeNode(data);

        if (node.val > data)
            node.left = createNode(node.left, data);
        
        if (node.val < data)
            node.right = createNode(node.right, data);

        return node;
    }
}