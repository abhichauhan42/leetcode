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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted=new ArrayList<>();
        inOrderTraversal(root,sorted);
        
        return buildBst(sorted,0,sorted.size()-1);
    }
    
    private void inOrderTraversal(TreeNode node,List<Integer> sorted){
        if(node==null){
            return;
        }
        
        inOrderTraversal(node.left,sorted);
        sorted.add(node.val);
        inOrderTraversal(node.right,sorted);
    }
    
    private TreeNode buildBst(List<Integer> sorted,int start,int end){
        if(start>end){
            return null;
        }
        
        int mid=start+(end-start)/2;
        TreeNode node=new TreeNode(sorted.get(mid));
        node.left=buildBst(sorted,start,mid-1);
        node.right=buildBst(sorted,mid+1,end);
        
        return node;
    }
}