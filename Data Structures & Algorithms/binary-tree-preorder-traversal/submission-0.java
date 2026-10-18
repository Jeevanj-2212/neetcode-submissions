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
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode current = root;
        traversal(current);
        return result;
        
    }

    public void traversal(TreeNode current) {
        if(current==null) {
            return;
        }
        else {
            result.add(current.val);

            traversal(current.left);
            traversal(current.right);
            

        }
    }
}