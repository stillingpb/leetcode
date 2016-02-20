package round1;

import java.util.ArrayList;
import java.util.List;

public class Balanced_Binary_Tree {
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

    public TreeNode createTree() {
        String treeStr = "3,1,5,0,2,4,6,#,#,#,3";
        String[] nstr = treeStr.split(",");
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(new TreeNode(Integer.parseInt(nstr[0])));
        for (int i = 1, count = 0; i < nstr.length; i++, count++) {
            if ("#".equals(nstr[i]))
                continue;
            TreeNode newNode = new TreeNode(Integer.parseInt(nstr[i]));
            nodes.add(newNode);
            TreeNode par = nodes.get(count / 2);
            if (count % 2 == 0)
                par.left = newNode;
            else
                par.right = newNode;
        }
        return nodes.get(0);
    }

    private void intraverse(TreeNode root) {
        if (root == null)
            return;
        intraverse(root.left);
        System.out.print(root.val + " ");
        intraverse(root.right);
    }

    private void pretraverse(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        pretraverse(root.left);
        pretraverse(root.right);
    }

    public static void main(String[] args) {
        Balanced_Binary_Tree b = new Balanced_Binary_Tree();
        TreeNode root = b.createTree();
        System.out.println(b.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (isBalanced2(root) < 0) {
            return false;
        }
        return true;
    }

    private int isBalanced2(TreeNode root) {
        if (root == null)
            return 0;
        int leftDeep = isBalanced2(root.left);
        if (leftDeep < 0)
            return -1;
        int rightDeep = isBalanced2(root.right);
        if (rightDeep < 0)
            return -1;
        if (Math.abs(leftDeep - rightDeep) > 1)
            return -1;
        return leftDeep > rightDeep ? leftDeep : rightDeep;
    }
}
