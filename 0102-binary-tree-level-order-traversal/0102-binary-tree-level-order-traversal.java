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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> mainlist=new ArrayList<>();

        
        if(root==null){
            return mainlist;
        }
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        
        List<Integer> list = new ArrayList<>();
        
         while(!q.isEmpty()){
             TreeNode currNode=q.remove();
             if(currNode==null){
                 mainlist.add(new ArrayList<>(list));
                 
                 if(q.isEmpty()){
                     break;
                 }
                 else{
                     q.add(null);
                     list.clear(); //clear the list for next 
                 }
             }
             else{
                list.add(currNode.val);
                 if(currNode.left!=null){
                     q.add(currNode.left);
                 }
                 if(currNode.right!=null){
                     q.add(currNode.right);
                 }
             }
         }
        return mainlist;
    }
}