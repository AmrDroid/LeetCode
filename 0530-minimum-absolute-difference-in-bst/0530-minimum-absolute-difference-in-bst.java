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
    public int getMinimumDifference(TreeNode root) {
        
        ArrayList<Integer> list=new ArrayList();
        traverse(root,list);
        
        int res=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++)
        {
            res=Math.min(res,Math.abs(list.get(i)-list.get(i-1)));
        }
        return res;
    }
    
   void traverse(TreeNode root,ArrayList<Integer> list)
   {
       if(root ==null )return;
       
       
       traverse(root.left,list);
       list.add(root.val);
       traverse(root.right,list);
       
       
   }
}