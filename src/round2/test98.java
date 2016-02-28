package round2;

public class test98 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public String toString() {
            return val + "";
        }
    }

    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (prev != null && prev.val > root.val) {
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }
}
