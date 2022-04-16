/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
             
      
        if (root == null || root == p || root == q) {//if root == null or we find any one of the two, return root
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {//if we find both of them, LCA will be curr root
            return root;
        }
        if (left != null) {//we found any one of the two, return it
            return left;
        }
        if (right != null) {//we found any one of the two, return it
            return right;
        }
        return null;//we found nothing
    }
}