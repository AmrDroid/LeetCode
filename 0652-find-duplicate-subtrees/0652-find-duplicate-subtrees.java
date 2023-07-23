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
  
    List<TreeNode> result = new ArrayList<>();
    
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    
        if(root == null) {
            return result;
        }

        helper(root);

        return result;
    }

    private String helper(TreeNode node) {
        if(node == null) {
            return "";
        }

        String resultL = helper(node.left);
        String resultR = helper(node.right);
        int value = node.val;

        String str = value + "$" + resultL + "$" + resultR;

        map.put(str, map.getOrDefault(str, 0) + 1);


        if(map.get(str) == 2) {
            result.add(node);
        }
    
        return str;
    }
}