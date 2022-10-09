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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;
        Queue<TreeNode> q = new LinkedList();
        List<Integer> l=new ArrayList();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode t=q.peek();
            q.remove();
            if(l.contains((k-t.val)))return true;
            l.add(t.val);
            System.out.println(t.val);
            if(t.left!=null)
                q.add(t.left);
            if(t.right!=null)
                q.add(t.right);
        }
        return false;
    }
}