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
     private String dfs(TreeNode node, String current) {
        if (node == null)
            return null;

        current = (char) ('a' + node.val) + current;

        if (node.left == null && node.right == null) { // Leaf node
            return current;
        }

        String leftSmallest = dfs(node.left, current);
        String rightSmallest = dfs(node.right, current);

        if (leftSmallest == null)
            return rightSmallest;
        if (rightSmallest == null)
            return leftSmallest;

        return leftSmallest.compareTo(rightSmallest) < 0 ? leftSmallest : rightSmallest;
    }
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
}