package round2;

public class test226 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        invert(node.left);
        invert(node.right);
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}