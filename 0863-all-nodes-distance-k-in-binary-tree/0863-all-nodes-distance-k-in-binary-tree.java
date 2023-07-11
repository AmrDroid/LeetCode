/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         
    return findNodesDistanceKHelper(root, target.val, k);
  }

    
   private ArrayList<Integer> findNodesDistanceKHelper(TreeNode root, int target, int k) {
  
       Map<Integer, TreeNode> parents = new HashMap<>();

       populateParents(root, null, parents);

       Map<Integer, Boolean> visited = new HashMap<>();

    
       TreeNode targetNode = getTargetNode(root, target, parents);

       Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

       queue.add(new Pair<TreeNode, Integer>(targetNode, 0));

       visited.put(targetNode.val, true);

  
       while (!queue.isEmpty()) {
      
           Pair<TreeNode, Integer> pair = queue.poll();

           TreeNode currentNode = pair.first;
           
           int distance = pair.second;

    
           if (distance == k) {

               ArrayList<Integer> nodesDistanceK = new ArrayList<>();

               nodesDistanceK.add(currentNode.val);

               for (Pair<TreeNode, Integer> p : queue) 
                   nodesDistanceK.add(p.first.val);

               return nodesDistanceK;
            }

      
           List<TreeNode> neighbors = new ArrayList<>();
           neighbors.add(currentNode.left);
           neighbors.add(currentNode.right);
           neighbors.add(parents.get(currentNode.val));


           for (TreeNode node : neighbors) {

               if (node == null) continue;

               if (visited.containsKey(node.val)) continue;

               visited.put(node.val, true);

               queue.add(new Pair<TreeNode, Integer>(node, distance + 1));
           }
    }

    return new ArrayList<>();
  }

  private void populateParents(TreeNode root, TreeNode parent, Map<Integer, TreeNode> parents) {

    if (root == null) return;

    parents.put(root.val, parent);

    populateParents(root.left, root, parents);
    populateParents(root.right, root, parents);
  }

  private TreeNode getTargetNode(TreeNode root, int target, Map<Integer, TreeNode> parents) {
    if (root.val == target) return root;

    TreeNode parent = parents.get(target);

    return parent.left != null && parent.left.val == target ? parent.left : parent.right;
  }
    
    
    
    
    
 class Pair<U, V> {
    final U first;
    final V second;

    public Pair(U first, V second) {
      this.first = first;
      this.second = second;
    }
  }
    



}