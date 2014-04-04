package round1;

import java.util.ArrayList;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {

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
		Binary_Tree_Postorder_Traversal b = new Binary_Tree_Postorder_Traversal();
		TreeNode root = b.createTree();
		ArrayList<Integer> list = b.postorderTraversal(new TreeNode(1));
		System.out.println(list);
	}

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode visited = null;
		TreeNode node = root;
		if (node != null)
			stack.push(node);
		while (!stack.isEmpty()) {
			node = stack.peek();
			if ((node.left == null && node.right == null)
					|| (visited != null && (visited == node.left || visited == node.right))) {
				node = stack.pop();
				list.add(node.val);
				visited = node;
			} else {
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
		}
		return list;
	}

}
