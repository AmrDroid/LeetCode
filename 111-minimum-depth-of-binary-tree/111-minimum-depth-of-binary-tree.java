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
    public int minDepth(TreeNode root) {
        
       
        if (root == null) return 0;
        
        int leftDepth = minDepth(root.left);
        
        int rightDepth = minDepth(root.right);
        
        if (leftDepth == 0 || rightDepth == 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        }
        else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
    
    /*
    
     if (root == null) {
            return 0;
        }
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 1));
        while (true) {
            Pair nodeLevel = queue.poll();
            TreeNode node = nodeLevel.node;
            int level = nodeLevel.level;
            if (node.left == null && node.right == null) {
                return level;
            }
            if (node.left != null) {
                queue.add(new Pair(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, level + 1));
            }
        }
    }
    
    static class Pair {
        TreeNode node;
        int level;
        
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    } 
    
    */
    
}