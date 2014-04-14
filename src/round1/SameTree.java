package round1;

import java.util.ArrayList;
import java.util.List;

public class SameTree {
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

	private void traverse(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		traverse(root.left);
		traverse(root.right);
	}

	public static void main(String[] args) {
		SameTree s = new SameTree();
		TreeNode r1 = s.createTree();
		TreeNode r2 = s.createTree();

		System.out.println(s.isSameTree(r1, r2));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return p == null && q == null;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
