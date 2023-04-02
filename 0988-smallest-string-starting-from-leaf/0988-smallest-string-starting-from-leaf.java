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
 
    List<String>ans=new LinkedList<>();
    
    public String smallestFromLeaf(TreeNode root) {
        helper(root,"");
       
        Collections.sort(ans,(a,b)->a.compareTo(b));
       // System.out.print(ans);
        // for(String s:ans){
        //   if(s.length()>1) return s;
        // }
        return ans.get(0);
        
        
    }
     void helper(TreeNode r,String s){
        if(r==null){
          return;
        }
        
        s+=getchar(r.val);
        if(r.left==null && r.right==null){
          ans.add(rev(s));
          return;
        }
        
        helper(r.left,s);
        
        
        helper(r.right,s);
        
      
        
    }
      String getchar(int i){
        return "abcdefghijklmnopqrstuvwxyz".substring(i, i+1);
    }
    String rev(String s){
      StringBuilder sb=new StringBuilder(s);
      sb.reverse();
      return sb.toString();
    }
}