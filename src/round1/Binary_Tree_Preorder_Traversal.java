package round1;

import java.util.ArrayList;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal {
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
		Binary_Tree_Preorder_Traversal b = new Binary_Tree_Preorder_Traversal();
		TreeNode root = b.createTree();
		ArrayList<Integer> list = b.preorderTraversal(root);
		System.out.println(list);
	}

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode p = root;
		stack.push(p);
		while (!stack.isEmpty()) {
			p = stack.pop();
			while (p != null) {
				stack.push(p);
				list.add(p.val);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				stack.push(p.right);
			}
		}

		// TreeNode p = root;
		// if (p == null)
		// return list;
		// stack.push(p);
		// while (!stack.isEmpty()) {
		// p = stack.pop();
		// while (p != null) {
		// System.out.println(p.val);
		// list.add(p.val);
		// stack.push(p);
		// p = p.left;
		// }
		// p = stack.pop();
		// while (!stack.isEmpty() && p.right == null) {
		// p = stack.pop();
		// }
		// if (p.right != null)
		// stack.push(p.right);
		// }
		return list;
	}

}
