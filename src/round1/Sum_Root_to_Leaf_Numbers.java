package round1;

import java.util.ArrayList;
import java.util.List;

public class Sum_Root_to_Leaf_Numbers {

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
		String treeStr = "1,3,2,2,4";
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
		Sum_Root_to_Leaf_Numbers s = new Sum_Root_to_Leaf_Numbers();
		TreeNode root = s.createTree();
		System.out.println(s.sumNumbers(root));
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return sumNumbers(root, 0);
	}

	private int sumNumbers(TreeNode node, int sum) {
		sum = sum * 10 + node.val;
		if (node.left == null && node.right == null)
			return sum;
		int s = 0;
		if (node.left != null)
			s += sumNumbers(node.left, sum);
		if (node.right != null)
			s += sumNumbers(node.right, sum);
		return s;
	}
}
