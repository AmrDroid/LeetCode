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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l=new ArrayList();
        
        traverse(root,l);
        return l;
    }
    void traverse(TreeNode root, List<Integer> l)
    {
       if (root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        // traverse the tree
        while (curr != null || s.size() > 0) {
            /* Reach the left most Node of the
            curr Node */
            while (curr != null) {/* place pointer to a tree node on the stack before traversing the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }
            /* Current must be NULL at this point */
            curr = s.pop();
            l.add(curr.val);
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }
}