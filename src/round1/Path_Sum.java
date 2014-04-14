package round1;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum {
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
		String treeStr = "1,2";
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
		Path_Sum p = new Path_Sum();
		TreeNode root = p.createTree();
		System.out.println(p.hasPathSum(root, 1));
		System.out.println(p.hasPathSum(root, 3));
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return sum == root.val;
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}

}
