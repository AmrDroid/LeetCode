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
    public List<Integer> rightSideView(TreeNode root) {
     
        List<Integer> res=new ArrayList();
         if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();
            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                TreeNode temp = queue.poll();
                // Print the left most element at
                // the level
                if (i == 1)res.add(temp.val);
                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);

                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);
            }
        }
        return res;
    
        
    }
}