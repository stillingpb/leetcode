package round1;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Maximum_Path_Sum {

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
		String treeStr = "1,3,1,2,5";
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
		Binary_Tree_Maximum_Path_Sum b = new Binary_Tree_Maximum_Path_Sum();
		TreeNode head = b.createTree();
		System.out.println(b.maxPathSum(head));
	}

	public int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		maxPathSum(root, max);
		return max[0];
	}

	private int maxPathSum(TreeNode node, int max[]) {
		if (node == null)
			return 0;
		int leftPathSum = maxPathSum(node.left, max);
		int rightPathSum = maxPathSum(node.right, max);
		int pathSum = node.val;
		pathSum += leftPathSum > 0 ? leftPathSum : 0;
		pathSum += rightPathSum > 0 ? rightPathSum : 0;
		max[0] = Math.max(max[0], pathSum);
		return Math.max(Math.max(leftPathSum, rightPathSum), 0) + node.val;
	}

}
