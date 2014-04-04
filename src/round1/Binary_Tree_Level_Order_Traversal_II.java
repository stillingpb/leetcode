package round1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree_Level_Order_Traversal_II {

	public static void main(String[] args) {
		Binary_Tree_Level_Order_Traversal_II m = new Binary_Tree_Level_Order_Traversal_II();
		TreeNode root = m.createTree();

		ArrayList<ArrayList<Integer>> ans = m.levelOrderBottom(root);
		System.out.println(ans);
	}

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

	static class LevelTreeNode {
		TreeNode node;
		int level;

		LevelTreeNode(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ans;

		Queue<LevelTreeNode> queue = new LinkedList<LevelTreeNode>();
		Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
		queue.add(new LevelTreeNode(root, 0));

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		stack.push(list);

		int level = 0;
		while (queue.peek() != null) {
			LevelTreeNode lnode = queue.poll();
			TreeNode node = lnode.node;
			if (lnode.level == level) {
				level++;
				list = new ArrayList<Integer>();
				stack.push(list);
			}
			if (node.left != null) {
				queue.add(new LevelTreeNode(node.left, level));
				list.add(node.left.val);
			}
			if (node.right != null) {
				queue.add(new LevelTreeNode(node.right, level));
				list.add(node.right.val);
			}
		}
		stack.pop();
		while (!stack.isEmpty()) {
			ans.add(stack.pop());
		}
		return ans;
	}

}
