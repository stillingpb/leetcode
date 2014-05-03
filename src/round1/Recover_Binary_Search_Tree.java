package round1;

import java.util.ArrayList;
import java.util.List;

public class Recover_Binary_Search_Tree {
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
		String treeStr = "4,2,5,1,3,6";
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

	public static void main(String[] args) {
		Recover_Binary_Search_Tree r = new Recover_Binary_Search_Tree();
		TreeNode root = r.createTree();

		r.intraverse(root);

		r.recoverTree(root);
		System.out.println();
		r.intraverse(root);
	}

	public void recoverTree(TreeNode root) {
		ArrayList<Integer> vals = new ArrayList<Integer>();
		intraverse(root, vals);

		int i = 0, len = vals.size();
		for (; i < len - 1; i++)
			if (vals.get(i) > vals.get(i + 1))
				break;
		int swap1 = i;
		for (i = len - 1; i >= 0; i--)
			if (vals.get(i - 1) > vals.get(i))
				break;
		int swap2 = i;
		int temp = vals.get(swap1);
		vals.set(swap1, vals.get(swap2));
		vals.set(swap2, temp);

		setIntraverse(root, vals);
	}

	int index = 0;

	private void setIntraverse(TreeNode node, ArrayList<Integer> vals) {
		if (node == null)
			return;
		setIntraverse(node.left, vals);
		node.val = vals.get(index++);
		setIntraverse(node.right, vals);
	}

	private void intraverse(TreeNode node, ArrayList<Integer> vals) {
		if (node == null)
			return;
		intraverse(node.left, vals);
		vals.add(node.val);
		intraverse(node.right, vals);
	}
}
