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
    public boolean leafSimilar(TreeNode tree1, TreeNode tree2) {
     
         // Write your code here.
    TreeNode tree1Head = createLinkedList(tree1, null, null)[0];
    TreeNode tree2Head = createLinkedList(tree2, null, null)[0];

    while (tree1Head != null && tree2Head != null) {
      if (tree1Head.val != tree2Head.val) return false;

      tree1Head = tree1Head.right;
      tree2Head = tree2Head.right;
    }

    return tree1Head == null && tree2Head == null;
  }

  private TreeNode[] createLinkedList(TreeNode current, TreeNode head, TreeNode prev) {
    if (current == null) return new TreeNode[] {head, prev};

    if (isLeafNode(current)) {
      if (prev == null) head = current;
      else prev.right = current;

      prev = current;
    }

    TreeNode[] leftNodeHeadAndPrev = createLinkedList(current.left, head, prev);

    return createLinkedList(current.right, leftNodeHeadAndPrev[0], leftNodeHeadAndPrev[1]);
  }
    

  private boolean isLeafNode(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }
}