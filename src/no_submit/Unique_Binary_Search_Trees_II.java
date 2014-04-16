package no_submit;

import java.util.ArrayList;

public class Unique_Binary_Search_Trees_II {
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
		Unique_Binary_Search_Trees_II u = new Unique_Binary_Search_Trees_II();
		ArrayList<TreeNode> heads = u.generateTrees(0);
		for (TreeNode h : heads) {
			u.pretraverse(h);
			System.out.println();
		}
	}

	public ArrayList<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	private ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> heads = new ArrayList<TreeNode>();
		if (start > end) {
			heads.add(null);
			return heads;
		}
		if (start == end) {
			TreeNode node = new TreeNode(start);
			heads.add(node);
			return heads;
		}
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> leftNodes = generateTrees(start, i - 1);
			ArrayList<TreeNode> rightNodes = generateTrees(i + 1, end);
			for (TreeNode left : leftNodes) {
				for (TreeNode right : rightNodes) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					heads.add(node);
				}
			}
		}
		return heads;
	}
}
