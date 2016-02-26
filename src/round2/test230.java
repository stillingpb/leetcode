package round2;

public class test230{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int val = kthSmallest(root.left, k);
        if (count++ >= k) {
            return val;
        }
        if (count == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }
}