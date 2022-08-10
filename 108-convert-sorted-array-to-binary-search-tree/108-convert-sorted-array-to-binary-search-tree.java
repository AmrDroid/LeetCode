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
    public TreeNode sortedArrayToBST(int[] nums) {
         return build(nums,0,nums.length-1);
    }
    public TreeNode build(int[] nums,int s,int e){
        if (s>e) {
            return null;
        }
        int m=(s+e)/2;
        int val=nums[m];
        TreeNode node=new TreeNode(val);
        node.left=build(nums,s,m-1);
        node.right=build(nums,m+1,e);
        return node;
    }}