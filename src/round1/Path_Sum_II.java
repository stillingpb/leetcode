package round1;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {
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
		String treeStr = "5,4,8,11,#,13,4,7,2,#,#,5,1";
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

	private void pretraverse(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		pretraverse(root.left);
		pretraverse(root.right);
	}

	public static void main(String[] args) {
		Path_Sum_II p = new Path_Sum_II();
		TreeNode root = p.createTree();
		
		System.out.println(p.pathSum(root, 22));
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ans;
		ArrayList<Integer> path = new ArrayList<Integer>();
		pathSum(ans, path, root, sum);
		return ans;
	}

	private void pathSum(ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> path, TreeNode node, int sum) {
		path.add(node.val);
		if (node.left == null && node.right == null) {
			if (sum - node.val == 0) {
				ArrayList<Integer> list = new ArrayList<Integer>(path);
				ans.add(list);
			}
			path.remove(path.size() - 1);
			return;
		}
		if (node.left != null)
			pathSum(ans, path, node.left, sum - node.val);
		if (node.right != null)
			pathSum(ans, path, node.right, sum - node.val);
		path.remove(path.size() - 1);
	}
}
