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
     private void dfs(TreeNode node, StringBuilder current, StringBuilder smallest) {
        if (node == null)
            return;

        current.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) { // Leaf node
            current.reverse(); // Reverse the current string to get the string from leaf to root
            String currentString = current.toString();
            if (smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0) {
                smallest.setLength(0);
                smallest.append(currentString);
            }
            current.reverse(); // Re-reverse the current string to maintain the original order
        } else {
            dfs(node.left, current, smallest);
            dfs(node.right, current, smallest);
        }

        current.deleteCharAt(current.length() - 1); // Backtrack
    }
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        dfs(root, new StringBuilder(), smallest);
        return smallest.toString();
    }
}