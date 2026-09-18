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



public class Codec {

    // Serialize
    public String serialize(TreeNode root) {

        if (root == null) {
            return "null";
        }

        return root.val + "," +
               serialize(root.left) + "," +
               serialize(root.right);
    }


    // Deserialize
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>();

        for (String value : values) {
            queue.add(value);
        }

        return buildTree(queue);
    }


    private TreeNode buildTree(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));

        node.left = buildTree(queue);
        node.right = buildTree(queue);

        return node;
    }
}