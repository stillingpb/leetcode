package round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
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
		String treeStr = "3,9,20,#,#,15,7";
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

	public static void main(String[] args) {
		Binary_Tree_Zigzag_Level_Order_Traversal b = new Binary_Tree_Zigzag_Level_Order_Traversal();
		TreeNode root = b.createTree();
		System.out.println(b.zigzagLevelOrder(root));
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ans;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> levels = new LinkedList<Integer>();
		nodes.offer(root);
		levels.offer(0);

		int curLevel = -1;
		ArrayList<Integer> curList = null;

		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			int level = levels.poll();
			if (curLevel != level) {
				curList = new ArrayList<Integer>();
				ans.add(curList);
				curLevel = level;
			}
			curList.add(node.val);
			if (node.left != null) {
				nodes.offer(node.left);
				levels.offer(level + 1);
			}
			if (node.right != null) {
				nodes.offer(node.right);
				levels.offer(level + 1);
			}
		}
		for (int i = 1, size = ans.size(); i < size; i += 2)
			Collections.reverse(ans.get(i));
		return ans;
	}
}
