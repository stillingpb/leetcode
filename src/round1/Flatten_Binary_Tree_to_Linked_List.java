package round1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Flatten_Binary_Tree_to_Linked_List {
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
		String treeStr = "1,2,5,3,4,#,6";
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
		Flatten_Binary_Tree_to_Linked_List f = new Flatten_Binary_Tree_to_Linked_List();
		TreeNode root = f.createTree();
		f.flatten(root);
		f.intraverse(root);
	}

	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		preTraverse(root, stack);
		TreeNode pre = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			cur.left = null;
			cur.right = pre;
			pre = cur;
		}
	}

	private void preTraverse(TreeNode node, Stack<TreeNode> stack) {
		if (node == null)
			return;
		stack.push(node);
		preTraverse(node.left, stack);
		preTraverse(node.right, stack);
	}
}
