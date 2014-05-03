package round1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {
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
		String treeStr = "1,2,3,4,5,6,7";
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
		Binary_Tree_Inorder_Traversal b = new Binary_Tree_Inorder_Traversal();
		TreeNode root = b.createTree();
		System.out.println(b.inorderTraversal(root));
	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				ans.add(node.val);
				stack.push(node.right);
			}
		}
		return ans;
	}

}
