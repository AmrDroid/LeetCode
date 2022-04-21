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
   Map<Integer, List> map=new HashMap<Integer, List>();

   public List allPossibleFBT(int n) {


       List <TreeNode> list=new ArrayList<TreeNode>();
      
       if(map.containsKey(n))
            return map.get(n);

    if (n==1)
    {         
        TreeNode node=new TreeNode(0);
        list.add(node);
          return list;
    }
       else{
    
    
           for(int i=1;i<=n-2;i++){
       
             List<TreeNode> leftbabys=allPossibleFBT(i);
               
             List<TreeNode> rightbabys=allPossibleFBT(n-i-1);
        
        for(int left=0;left<leftbabys.size();left++){
            for(int right=0;right<rightbabys.size();right++){
              list.add(new TreeNode(0,leftbabys.get(left),rightbabys.get(right)));
               
            }            
            }
        }    
    }
       
    map.put(n,list);
    return list;
    }
}