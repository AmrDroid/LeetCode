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
    public List<List<Integer>> levelOrder(TreeNode root) {
         Queue<TreeNode> q = new LinkedList();
        q.add(root);
        List<List<Integer>> list=new ArrayList();
        if(root==null)return list;
        while(!q.isEmpty())
        {
            List<Integer> l=new ArrayList();
            int size=q.size();
            while(size>0)
            {
                 TreeNode n=q.peek();
                q.remove();

                if(n.left!=null)q.add(n.left);
                if(n.right!=null)q.add(n.right);
                size--;
                l.add(n.val);
            }
            list.add(l);
        }
        return list;
    }
}