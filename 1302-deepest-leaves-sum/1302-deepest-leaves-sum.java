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
    public int deepestLeavesSum(TreeNode root) {
        int sum=0;
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
            TreeNode n =q.peek();
            q.remove();
                sum+=n.val;
            if(n.left!=null)q.add(n.left);
            if(n.right!=null)q.add(n.right);
            }
            if(q.size()!=0)
                sum=0;
            
        }
    return sum;
    }
}