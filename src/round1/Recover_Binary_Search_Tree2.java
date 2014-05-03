package round1;

import java.util.ArrayList;
import java.util.List;

public class Recover_Binary_Search_Tree2 {
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
		Recover_Binary_Search_Tree2 r = new Recover_Binary_Search_Tree2();
		TreeNode root = r.createTree();

		r.intraverse(root);

		r.recoverTree(root);
		System.out.println();
		r.intraverse(root);
	}

	public void recoverTree(TreeNode root) {
		intraverseAscending(root);
		intraverseDescending(root);
		int temp = swap1.val;
		swap1.val = swap2.val;
		swap2.val = temp;
	}

	TreeNode swap1;
	TreeNode swap2;
	TreeNode pre;
	TreeNode post;

	private void intraverseAscending(TreeNode node) {
		if (node == null || swap1 != null)
			return;
		intraverseAscending(node.left);
		if (pre == null)
			pre = node;
		if (pre.val > node.val) {
			swap1 = pre;
			return;
		}
		pre = node;
		intraverseAscending(node.right);
	}

	private void intraverseDescending(TreeNode node) {
		if (node == null || swap2 != null)
			return;
		intraverseDescending(node.right);
		if (post == null)
			post = node;
		if (post.val < node.val) {
			swap2 = post;
			return;
		}
		post = node;
		intraverseDescending(node.left);
	}
}
