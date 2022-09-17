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

    int total=0;
    public int pseudoPalindromicPaths (TreeNode root) {
          
        int count[] = new int[10];
        dfs(root, count);
        return total;
        
    }
    
 void dfs(TreeNode root, int count[]){
        if(root == null){
            return;    
        }
        
        if(root.left == null && root.right == null){
            count[root.val]++;
            if(validPalindrome(count))
                total++;
            count[root.val]--;
            return;
        }
        
        count[root.val]++;
        dfs(root.left, count);
        dfs(root.right, count);
        count[root.val]--;
    }
    
    boolean validPalindrome(int count[]){
        int oddCount = 0;
        for(int i = 1; i < count.length; i++){
            if(count[i] % 2 == 1)
                oddCount++;
            
            if(oddCount > 1)
                return false;
        }
        return true;
    }
}