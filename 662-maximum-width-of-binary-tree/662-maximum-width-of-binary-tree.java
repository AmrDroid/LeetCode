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
    public int widthOfBinaryTree(TreeNode root) {
    
         if ( root == null ) return 0;
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> idx = new ArrayList<Integer>();
        
        
        queue.addLast(root);
        idx.add(0);
        
        int res = 1;
        
        while (!queue.isEmpty()) {
        
            res = Math.max(res, idx.get(idx.size()-1) - idx.get(0) + 1);
                
            List<Integer> levelIdx = new ArrayList<Integer>();
         
            int n = queue.size();
            
            for (int i = 0; i < n ; i++ ) {
            
                TreeNode node = queue.removeFirst();
                
                if (node.left != null) {
                    queue.addLast(node.left);
                    levelIdx.add(idx.get(i) * 2);
                }
                
                if (node.right != null) {
                    queue.addLast(node.right);
                    levelIdx.add(idx.get(i) * 2 + 1);
                }
            }
            idx = levelIdx;
        }
        return res;
    }             
}