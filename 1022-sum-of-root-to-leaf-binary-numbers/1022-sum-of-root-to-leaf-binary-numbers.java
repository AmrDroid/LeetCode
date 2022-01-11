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
    int result=0;
    public int sumRootToLeaf(TreeNode root) {
        sum(root,"");
        return result;
        
    }
    void sum(TreeNode root,String sum)
    {
        if(root==null)return;
        if(root.left==null&&root.right==null){
            sum+=root.val;
            result+=Integer.parseInt(sum,2);
         }
        sum+=root.val+"";
        System.out.println(sum);
        sum(root.left,sum);
        sum(root.right,sum);
    }
}