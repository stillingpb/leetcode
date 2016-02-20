package round2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {
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

    TreeNode findParent(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        if (root == n1 || root == n2) {
            return root;
        }
        TreeNode left = findParent(root.left, n1, n2);
        TreeNode right = findParent(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}
