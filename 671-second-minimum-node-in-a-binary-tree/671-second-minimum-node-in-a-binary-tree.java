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
           
    int firstMinimum=Integer.MAX_VALUE;    
    int secondMinimum=Integer.MAX_VALUE;    
    boolean secondMinimumFound=false;


    public int findSecondMinimumValue(TreeNode root) {
            firstMinimum = root.val;
            findSecondMinimum(root);
        
            if(!secondMinimumFound)return -1;
        
        return secondMinimum;
    
    }

    
    private void findSecondMinimum(TreeNode root) {
    
        if (root == null) return;
        
        if (root.val < firstMinimum) {
                firstMinimum = root.val;
                secondMinimum = firstMinimum;
        
        } else if (root.val > firstMinimum && root.val <= secondMinimum) {
                secondMinimumFound=true;
                secondMinimum = root.val;
        
        }
        
        if (root.left != null) {
        
            findSecondMinimum(root.left);
            
            findSecondMinimum(root.right);
            
        }
    
    }
}