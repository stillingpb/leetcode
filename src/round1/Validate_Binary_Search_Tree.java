package round1;

import java.util.ArrayList;
import java.util.List;

public class Validate_Binary_Search_Tree {
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
		String treeStr = "0,-1";
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
		Validate_Binary_Search_Tree v = new Validate_Binary_Search_Tree();
		TreeNode root = v.createTree();

		boolean ans = v.isValidBST(root);
		System.out.println(ans);
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		int val[] = new int[2];
		return isValidBST(root, val);
	}

	private boolean isValidBST(TreeNode node, int[] val) {
		boolean valid = true;
		int[] leftVal = null;
		int[] rightVal = null;
		if (node.left != null) {
			leftVal = new int[2];
			valid = node.left.val < node.val && isValidBST(node.left, leftVal)
					&& leftVal[1] < node.val;
		}
		if (valid && node.right != null) {
			rightVal = new int[2];
			valid = node.val < node.right.val
					&& isValidBST(node.right, rightVal)
					&& node.val < rightVal[0];
		}
		if (!valid)
			return valid;
		if (node.left != null) {
			val[0] = leftVal[0];
		} else
			val[0] = node.val;
		if (node.right != null)
			val[1] = rightVal[1];
		else
			val[1] = node.val;
		return true;
	}
}
