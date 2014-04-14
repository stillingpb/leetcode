package round1;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Depth_of_Binary_Tree {

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
		Minimum_Depth_of_Binary_Tree m = new Minimum_Depth_of_Binary_Tree();
		TreeNode root = m.createTree();
		System.out.println(m.minDepth(root));
	}

	public int minDepth(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		int min = Integer.MAX_VALUE;
		if (node.left != null)
			min = minDepth(node.left);
		if (node.right != null) {
			int right = minDepth(node.right);
			min = right < min ? right : min;
		}
		return min + 1;
	}
}
