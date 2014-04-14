package round1;

import java.util.ArrayList;
import java.util.List;

public class Symmetric_Tree {
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

	public TreeNode createTree(String treeStr) {
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

	public static void main(String[] args) {
		Symmetric_Tree s = new Symmetric_Tree();
		TreeNode r1 = s.createTree("1,2,2,3,4,4,3");
		System.out.println(s.isSymmetric(r1));
	}

	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root,root);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == null && right == null;
		if (left.val != right.val)
			return false;
		return isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}
}
