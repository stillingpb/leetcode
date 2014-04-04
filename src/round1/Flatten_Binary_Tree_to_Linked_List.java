package round1;

import java.util.Stack;

public class Flatten_Binary_Tree_to_Linked_List {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode createTree() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		t3.left = t5;
		return t1;
	}

	public static void main(String[] args) {
		Flatten_Binary_Tree_to_Linked_List obj = new Flatten_Binary_Tree_to_Linked_List();
		TreeNode root = obj.createTree();

		obj.flatten(null);

		// TreeNode node = root;
		// while (node != null) {
		// System.out.println(node.val);
		// if(node.left != null)
		// System.out.println("error");
		// node = node.right;
		// }
	}

	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		preOrderTraverse(root, stack);
		TreeNode pre = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			cur.left = null;
			cur.right = pre;
			pre = cur;
		}
	}

	private void preOrderTraverse(TreeNode node, Stack<TreeNode> stack) {
		if (node == null)
			return;
		stack.push(node);
		preOrderTraverse(node.left, stack);
		preOrderTraverse(node.right, stack);
	}
}
