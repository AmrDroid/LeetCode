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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> l1= traverse(root1,new ArrayList());
        List<Integer> l2= traverse(root2,new ArrayList());
        
        int i=0,j=0,n=l1.size(),m=l2.size();
        
        List<Integer> res=new ArrayList();
        
        
        while(i<n&&j<m)
        {
            
            if(l1.get(i)<l2.get(j))
            {
                res.add(l1.get(i++));
            }
            else
            {
                res.add(l2.get(j++));
                
            }
        }
        while(i<n)
            res.add(l1.get(i++));
        
        while(j<m)
            res.add(l2.get(j++));        
        
        
        return res;
    }
    
    List<Integer> traverse(TreeNode root,List<Integer> res)
    {
        if(root ==null)
            return res;
        
        
        res=traverse(root.left,res);
        res.add(root.val);
        res=traverse(root.right,res);
        
        return res;
    }
    
}