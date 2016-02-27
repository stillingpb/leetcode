package round2;

/**
 * Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST.
 */
public class Correct_The_BST {
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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;

    public void corret(TreeNode root) {
        inOrderTrverse(root);
        if (first == null) {
            return;
        } else if (last == null) { // is adjacent: first != null && last == null
            swapNode(first, middle);
        } else {//is not adjacent:  first != null && last != null
            swapNode(first, last);
        }
    }

    private void swapNode(TreeNode n1, TreeNode n2) {
        int tmpVal = n1.val;
        n1.val = n2.val;
        n2.val = tmpVal;
    }

    private void inOrderTrverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTrverse(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
                middle = node;
            } else {
                last = prev;
            }
        } else {
            prev = node;
        }
        inOrderTrverse(node.right);
    }
}
