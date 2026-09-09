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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If subRoot is empty, it is a subtree
        if (subRoot == null) {
            return true;
        }

        // If root is empty but subRoot isn't
        if (root == null) {
            return false;
        }

        // Check if trees starting from these nodes are identical
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search in left and right subtrees
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {

        // Both are null
        if (p == null && q == null) {
            return true;
        }

        // One is null, other isn't
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Compare left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}