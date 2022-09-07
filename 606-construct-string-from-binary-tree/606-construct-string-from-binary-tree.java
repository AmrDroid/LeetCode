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
    
    public String tree2str(TreeNode t) {
    
            String res = "";
        if (t == null) {
            return "";
        }
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if ("".equals(left) && !"".equals(right)) {
            return t.val + "()" + "(" + right + ")";
        
        } else if (!"".equals(left) && "".equals(right)) {
        
            return t.val + "(" + left + ")";

        } else if ("".equals(left) && "".equals(right)) {
        
            return t.val + "";
        }

        return t.val +                "(" + left + ")" +                "(" + right + ")";
        
    }
}